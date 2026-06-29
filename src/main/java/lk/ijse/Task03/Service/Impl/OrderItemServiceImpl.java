package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.OrderProductDTO;
import lk.ijse.Task03.DTO.PlaceOrderDTO;
import lk.ijse.Task03.Entity.Customer;
import lk.ijse.Task03.Entity.Order;
import lk.ijse.Task03.Entity.OrderItem;
import lk.ijse.Task03.Entity.Product;
import lk.ijse.Task03.Repository.CustomerRepository;
import lk.ijse.Task03.Repository.OrderItemRepository;
import lk.ijse.Task03.Repository.OrderRepository;
import lk.ijse.Task03.Repository.ProductRepository;
import lk.ijse.Task03.Service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public PlaceOrderDTO placeOrder(PlaceOrderDTO placeOrderDTO) {
        log.info("OrderItemServiceImpl - placeOrder() called with order details: {}", placeOrderDTO);
        try {

            Order order = new Order();
            order.setTotalAmount(placeOrderDTO.getTotalAmount());
            order.setOrderDate(LocalDate.now());

            Optional<Customer> optionalCustomer = customerRepository.findById(placeOrderDTO.getCustomerId());
            if (optionalCustomer.isEmpty()){
                throw new RuntimeException("Customer not found with ID: " + placeOrderDTO.getCustomerId());
            }
            Customer customer = optionalCustomer.get();
            order.setCustomer(customer);

            log.info("Debug customer");

            Order saveOrder = orderRepository.save(order);

            for (OrderProductDTO productId : placeOrderDTO.getItemIdList()){
                OrderItem orderItem = new OrderItem();

                Optional<Product> optionalProduct = productRepository.findById(productId.getProductId());
                if (optionalProduct.isEmpty()) {
                    throw new RuntimeException("Product not found with ID: " + productId);
                }

                Product product = optionalProduct.get();
                orderItem.setProduct(product);
                orderItem.setOrder(saveOrder);
                orderItem.setProductQty(productId.getQuantity());
                orderItem.setTotal(productId.getPrice() * productId.getQuantity());

                orderItemRepository.save(orderItem);

            }

            PlaceOrderDTO responseDTO = new PlaceOrderDTO();
            responseDTO.setItemIdList(placeOrderDTO.getItemIdList());
            responseDTO.setOrderDate(saveOrder.getOrderDate());
            responseDTO.setTotalAmount(saveOrder.getTotalAmount());
            responseDTO.setCustomerId(saveOrder.getCustomer().getCustomerId());

            return responseDTO;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlaceOrderDTO> getAllOrders() {
        log.info("OrderItemServiceImpl - getAllOrders() called");
        try {
            List<Order> orderList = orderRepository.findAll();
            log.info("Total orders found: {}", orderList.size());

            List<PlaceOrderDTO> responseList = new ArrayList<>();

            for (Order order : orderList){
                PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
                placeOrderDTO.setOrderDate(order.getOrderDate());
                placeOrderDTO.setTotalAmount(order.getTotalAmount());
                placeOrderDTO.setCustomerId(order.getCustomer().getCustomerId());

                List<OrderProductDTO> orderProductDTOList = new ArrayList<>();
                for (OrderItem orderItem : order.getOrderItemList()){
                    OrderProductDTO orderProductDTO = new OrderProductDTO();
                    orderProductDTO.setProductId(orderItem.getProduct().getProductId());
                    orderProductDTO.setQuantity(orderItem.getProductQty());
                    orderProductDTO.setPrice(orderItem.getTotal() / orderItem.getProductQty());
                    orderProductDTOList.add(orderProductDTO);
                }
                placeOrderDTO.setItemIdList(orderProductDTOList);
                responseList.add(placeOrderDTO);
            }

            return responseList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

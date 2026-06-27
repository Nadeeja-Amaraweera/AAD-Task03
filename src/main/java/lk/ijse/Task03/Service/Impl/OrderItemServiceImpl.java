package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.PlaceOrderDTO;
import lk.ijse.Task03.Repository.CustomerRepository;
import lk.ijse.Task03.Repository.OrderItemRepository;
import lk.ijse.Task03.Repository.OrderRepository;
import lk.ijse.Task03.Repository.ProductRepository;
import lk.ijse.Task03.Service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return null;
    }
}

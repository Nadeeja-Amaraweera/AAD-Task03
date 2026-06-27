package lk.ijse.Task03.Service;

import lk.ijse.Task03.DTO.PlaceOrderDTO;

import java.util.List;

public interface OrderItemService {

    PlaceOrderDTO placeOrder(PlaceOrderDTO placeOrderDTO);

    List<PlaceOrderDTO> getAllOrders();
}

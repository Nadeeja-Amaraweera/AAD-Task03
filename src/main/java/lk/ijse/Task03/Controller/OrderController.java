package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.PlaceOrderDTO;
import lk.ijse.Task03.Service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lk.ijse.Task03.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.Task03.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@Slf4j
@RestController
@RequestMapping("/v1/api/order")
public class OrderController {

    private final OrderItemService orderItemService;

    public OrderController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping(value = "/placeOrder",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO){
        PlaceOrderDTO placeOrderDTO1 = orderItemService.placeOrder(placeOrderDTO);
        return new CommonResponse(OPERATION_SUCCESS,placeOrderDTO1,SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/getAllOrders",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllOrders() {
        List<PlaceOrderDTO> orders = orderItemService.getAllOrders();
        return new CommonResponse(OPERATION_SUCCESS, orders, SUCCESS_MESSAGE);
    }
}

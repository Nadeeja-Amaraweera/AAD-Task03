package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.CustomerDTO;
import lk.ijse.Task03.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lk.ijse.Task03.Constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.Task03.Constant.ResponseStatusCode.OPERATION_SUCCESS;

@Slf4j
@RestController
@RequestMapping("/v1/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = customerService.saveCustomer(customerDTO);
        return new CommonResponse(OPERATION_SUCCESS,customerDTO1,SUCCESS_MESSAGE);
    }
}

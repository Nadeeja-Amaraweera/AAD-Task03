package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.SupplierDTO;
import lk.ijse.Task03.Service.SupplierService;
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
@RequestMapping("/v1/api/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveSupplier(@RequestBody SupplierDTO supplierDTO) {
        log.info("SupplierController - saveSupplier() called");
        SupplierDTO supplierDTO1 =  supplierService.saveSupplier(supplierDTO);
        return new CommonResponse(OPERATION_SUCCESS, supplierDTO1, SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        log.info("SupplierController - updateSupplier() called");
        SupplierDTO supplierDTO1 =  supplierService.updateSupplier(supplierDTO);
        return new CommonResponse(OPERATION_SUCCESS, supplierDTO1, SUCCESS_MESSAGE);
    }
}

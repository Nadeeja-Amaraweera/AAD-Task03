package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.SupplierRecordDTO;
import lk.ijse.Task03.Service.SupplierRecordService;
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
@RequestMapping("/v1/api/supplierRecord")
public class SupplierRecordController {
    private final SupplierRecordService supplierRecordService;

    public SupplierRecordController(SupplierRecordService supplierRecordService) {
        this.supplierRecordService = supplierRecordService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveSupplierRecord(@RequestBody SupplierRecordDTO supplierRecordDTO){
        SupplierRecordDTO supplierRecordDTO1 = supplierRecordService.saveSupplierRecord(supplierRecordDTO);
        return new CommonResponse(OPERATION_SUCCESS, supplierRecordDTO1, SUCCESS_MESSAGE);
    }
}

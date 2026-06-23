package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.ProductDTO;
import lk.ijse.Task03.Service.ProductService;
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
@RequestMapping("/v1/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.saveProduct(productDTO);
        return new CommonResponse(OPERATION_SUCCESS,productDTO1,SUCCESS_MESSAGE);
    }
}

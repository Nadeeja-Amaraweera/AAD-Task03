package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.ProductDTO;
import lk.ijse.Task03.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.updateProduct(productDTO);
        return new CommonResponse(OPERATION_SUCCESS,productDTO1,SUCCESS_MESSAGE);
    }

    @PatchMapping(value = "/updateQTY",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateProductPrice(@RequestBody ProductDTO productDTO) {
        ProductDTO productDTO1 = productService.updateProductInventory(productDTO);
        return new CommonResponse(OPERATION_SUCCESS, productDTO1, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/viewLowStock",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getProductById() {
        List<ProductDTO> productDTO = productService.viewLowStocks();
        return new CommonResponse(OPERATION_SUCCESS, productDTO, SUCCESS_MESSAGE);
    }
}

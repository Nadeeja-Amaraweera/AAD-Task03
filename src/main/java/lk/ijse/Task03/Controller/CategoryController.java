package lk.ijse.Task03.Controller;

import lk.ijse.Task03.Constant.CommonResponse;
import lk.ijse.Task03.DTO.CategoryDTO;
import lk.ijse.Task03.Service.CategoryService;
import lk.ijse.Task03.Service.Impl.CategoryServiceImpl;
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
@RequestMapping("/v1/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO returnDto = categoryService.saveCategory(categoryDTO);
        return new CommonResponse(OPERATION_SUCCESS,returnDto,SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO returnDto = categoryService.updateCategory(categoryDTO);
        return new CommonResponse(OPERATION_SUCCESS,returnDto,SUCCESS_MESSAGE);
    }
}

package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.CategoryDTO;
import lk.ijse.Task03.Entity.Category;
import lk.ijse.Task03.Repository.CategoryRepository;
import lk.ijse.Task03.Service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        log.info("CategoryServiceImpl - saveCategory() called");
        try {
            Category category =  new Category();
            category.setCategoryName(categoryDTO.getCategoryName());
            Category saveCategory = categoryRepository.save(category);

            CategoryDTO responseDto = new CategoryDTO();
            responseDto.setCategoryId(saveCategory.getCategoryId());
            responseDto.setCategoryName(saveCategory.getCategoryName());
            return responseDto;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        log.info("CategoryServiceImpl - updateCategory() called");
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getCategoryId());
            Category category = optionalCategory.get();

            category.setCategoryName(categoryDTO.getCategoryName());
            Category saveCategory = categoryRepository.save(category);

            CategoryDTO responseDto = new CategoryDTO();
            responseDto.setCategoryId(saveCategory.getCategoryId());
            responseDto.setCategoryName(saveCategory.getCategoryName());
            return responseDto;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

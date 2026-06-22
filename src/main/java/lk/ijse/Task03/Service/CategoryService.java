package lk.ijse.Task03.Service;

import lk.ijse.Task03.DTO.CategoryDTO;

public interface CategoryService {
    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO);


}

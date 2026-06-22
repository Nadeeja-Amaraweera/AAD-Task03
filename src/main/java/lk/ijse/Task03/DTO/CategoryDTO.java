package lk.ijse.Task03.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private long categoryId;
    private String categoryName;

    public CategoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }
}

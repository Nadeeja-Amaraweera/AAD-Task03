package lk.ijse.Task03.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private long productId;
    private String productName;
    private double productPrice;
    private int productQty;
    private long categoryId;

    public ProductDTO(String productName, double productPrice, int productQty, long categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.categoryId = categoryId;
    }
}

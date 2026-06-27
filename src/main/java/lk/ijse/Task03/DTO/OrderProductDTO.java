package lk.ijse.Task03.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDTO {
    private Long productId;
    private Integer quantity;
    private Double price;
}

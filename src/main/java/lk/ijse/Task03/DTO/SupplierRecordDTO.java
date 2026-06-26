package lk.ijse.Task03.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRecordDTO {
    private long supplierRecordId;
    private LocalDate restockDate;
    private int quantity;
    private long supplierId;
    private long productId;

    public SupplierRecordDTO( int quantity, long supplierId, long productId) {
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.productId = productId;
    }
}

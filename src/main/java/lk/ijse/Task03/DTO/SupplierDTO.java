package lk.ijse.Task03.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    private long supplierId;
    private String supplierName;
    private String supplierAddress;

    public SupplierDTO(String supplierName, String supplierAddress) {
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
    }
}

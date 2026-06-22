package lk.ijse.Task03.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SupplierRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierRecordId;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Product product;

}

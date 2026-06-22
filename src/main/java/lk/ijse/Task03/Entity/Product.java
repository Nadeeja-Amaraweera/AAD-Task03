package lk.ijse.Task03.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String productName;
    private double productPrice;
    private int productQty;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SupplierRecord> supplierRecordList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

}

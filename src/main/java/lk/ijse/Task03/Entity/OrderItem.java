package lk.ijse.Task03.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;
    private int productQty;
    private double total;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}

package lk.ijse.Task03.Repository;

import lk.ijse.Task03.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

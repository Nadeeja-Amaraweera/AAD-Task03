package lk.ijse.Task03.Repository;

import lk.ijse.Task03.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}

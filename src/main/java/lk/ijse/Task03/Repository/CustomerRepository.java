package lk.ijse.Task03.Repository;

import lk.ijse.Task03.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

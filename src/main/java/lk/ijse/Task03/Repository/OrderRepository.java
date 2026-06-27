package lk.ijse.Task03.Repository;

import lk.ijse.Task03.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

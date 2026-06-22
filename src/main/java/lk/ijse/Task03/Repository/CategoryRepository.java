package lk.ijse.Task03.Repository;

import lk.ijse.Task03.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

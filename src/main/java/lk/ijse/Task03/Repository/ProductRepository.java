package lk.ijse.Task03.Repository;

import lk.ijse.Task03.DTO.ProductDTO;
import lk.ijse.Task03.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "SELECT new lk.ijse.Task03.DTO.ProductDTO(p.productId,p.productName,p.productPrice,p.productQty,p.category.categoryId) FROM Product p WHERE p.productQty <= ?1")
    List<ProductDTO> findByProductQtyLessThanEqual(int i);


    @Query(value = "SELECT new lk.ijse.Task03.DTO.ProductDTO(p.productId,p.productName,p.productPrice,p.productQty,p.category.categoryId) FROM Product p WHERE (?1 IS NULL OR p.productName LIKE %?1%)")
    List<ProductDTO> filterProductByName(String productName);

    @Query(value = "SELECT new lk.ijse.Task03.DTO.ProductDTO(p.productId,p.productName,p.productPrice,p.productQty,p.category.categoryId) FROM Product p JOIN Category c ON p.category = c WHERE (?1 IS NULL OR c.categoryName LIKE %?1%)")
    List<ProductDTO> filterProductByCategoryName(String categoryName);
}

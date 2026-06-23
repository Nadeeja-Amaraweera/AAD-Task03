package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.CategoryDTO;
import lk.ijse.Task03.DTO.ProductDTO;
import lk.ijse.Task03.Entity.Category;
import lk.ijse.Task03.Entity.Product;
import lk.ijse.Task03.Repository.ProductRepository;
import lk.ijse.Task03.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        log.info("ProductServiceImpl - saveProduct() called");
        try {
            Product product = new Product();
            product.setProductName(productDTO.getProductName());
            product.setProductPrice(productDTO.getProductPrice());
            product.setProductQty(productDTO.getProductQty());

            Category category = new Category();
            category.setCategoryId(productDTO.getCategoryId());
            product.setCategory(category);
            Product saveProduct = productRepository.save(product);

            ProductDTO responseDTO = new ProductDTO();
            responseDTO.setProductId(saveProduct.getProductId());
            responseDTO.setProductName(saveProduct.getProductName());
            responseDTO.setProductPrice(saveProduct.getProductPrice());
            responseDTO.setProductQty(saveProduct.getProductQty());
            responseDTO.setCategoryId(saveProduct.getCategory().getCategoryId());
            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {

    }
}

package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.CategoryDTO;
import lk.ijse.Task03.DTO.ProductDTO;
import lk.ijse.Task03.Entity.Category;
import lk.ijse.Task03.Entity.Product;
import lk.ijse.Task03.Repository.CategoryRepository;
import lk.ijse.Task03.Repository.ProductRepository;
import lk.ijse.Task03.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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
    public ProductDTO updateProduct(ProductDTO productDTO) {
    log.info("ProductServiceImpl - updateProduct() called");
        try {
            Optional<Product> optionalProduct = productRepository.findById(productDTO.getProductId());
            if (!optionalProduct.isPresent()){
                throw new RuntimeException("Product not found with id: " + productDTO.getProductId());
            }
            Product product = optionalProduct.get();
            product.setProductId(productDTO.getProductId());
            product.setProductName(productDTO.getProductName());
            product.setProductPrice(productDTO.getProductPrice());
            product.setProductQty(productDTO.getProductQty());

            Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
            if (!optionalCategory.isPresent()){
                throw new RuntimeException("Category not found with id: " + productDTO.getCategoryId());
            }
            Category category = optionalCategory.get();
            product.setCategory(category);
            Product updateProduct =productRepository.save(product);

            ProductDTO responseDTO = new ProductDTO();
            responseDTO.setProductId(updateProduct.getProductId());
            responseDTO.setProductName(updateProduct.getProductName());
            responseDTO.setProductPrice(updateProduct.getProductPrice());
            responseDTO.setProductQty(updateProduct.getProductQty());
            responseDTO.setCategoryId(updateProduct.getCategory().getCategoryId());

            return responseDTO;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductDTO updateProductInventory(ProductDTO productDTO) {
        log.info("ProductServiceImpl - updateProductInventory() called");
        try {
            Optional<Product> optionalProduct = productRepository.findById(productDTO.getProductId());
            if (!optionalProduct.isPresent()){
                throw new RuntimeException("Product not found with id: " + productDTO.getProductId());
            }
            Product product = optionalProduct.get();
            product.setProductQty(productDTO.getProductQty());
            Product updateInventory  = productRepository.save(product);

            ProductDTO responseDTO = new ProductDTO();
            responseDTO.setProductId(updateInventory.getProductId());
            responseDTO.setProductName(updateInventory.getProductName());
            responseDTO.setProductPrice(updateInventory.getProductPrice());
            responseDTO.setProductQty(updateInventory.getProductQty());
            responseDTO.setCategoryId(updateInventory.getCategory().getCategoryId());

            return responseDTO;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDTO> viewLowStocks() {
        log.info("ProductServiceImpl - viewLowStocks() called");
        try {
            List<ProductDTO> lowStockProducts = productRepository.findByProductQtyLessThanEqual(100);
            if (lowStockProducts.isEmpty()){
                log.info("No low stock products found");
                return List.of();
            }
            List<ProductDTO> productDTOList = new ArrayList<>();
            for (ProductDTO product : lowStockProducts) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(product.getProductId());
                productDTO.setProductName(product.getProductName());
                productDTO.setProductPrice(product.getProductPrice());
                productDTO.setProductQty(product.getProductQty());
                productDTO.setCategoryId(product.getCategoryId());
                productDTOList.add(productDTO);
            }
            return productDTOList;


        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

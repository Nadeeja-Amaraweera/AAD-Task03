package lk.ijse.Task03.Service;

import lk.ijse.Task03.DTO.ProductDTO;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);
}

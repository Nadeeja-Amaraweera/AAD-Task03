package lk.ijse.Task03.Service;

import lk.ijse.Task03.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    ProductDTO updateProductInventory(ProductDTO productDTO);

    List<ProductDTO> viewLowStocks();
}

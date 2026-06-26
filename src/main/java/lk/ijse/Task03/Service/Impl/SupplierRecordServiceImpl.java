package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.SupplierRecordDTO;
import lk.ijse.Task03.Entity.Product;
import lk.ijse.Task03.Entity.Supplier;
import lk.ijse.Task03.Entity.SupplierRecord;
import lk.ijse.Task03.Repository.ProductRepository;
import lk.ijse.Task03.Repository.SupplierRecordRepository;
import lk.ijse.Task03.Repository.SupplierRepository;
import lk.ijse.Task03.Service.SupplierRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Service
public class SupplierRecordServiceImpl implements SupplierRecordService {

    private final SupplierRecordRepository supplierRecordRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;

    public SupplierRecordServiceImpl(SupplierRecordRepository supplierRecordRepository, SupplierRepository supplierRepository, ProductRepository productRepository) {
        this.supplierRecordRepository = supplierRecordRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public SupplierRecordDTO saveSupplierRecord(SupplierRecordDTO dto) {
        log.info("SupplierRecordServiceImpl - saveSupplierRecord() called");
        try {

            Optional<Supplier> optionalSupplier = supplierRepository.findById(dto.getSupplierId());
            if (!optionalSupplier.isPresent()) {
                throw new RuntimeException("Supplier not found with id: " + dto.getSupplierId());
            }
            Supplier supplier = optionalSupplier.get();

            Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
            if (!optionalProduct.isPresent()) {
                throw new RuntimeException("Product not found with id: " + dto.getProductId());
            }
            Product product = optionalProduct.get();

            SupplierRecord supplierRecord =  new SupplierRecord();
            supplierRecord.setSupplier(supplier);
            supplierRecord.setProduct(product);
            supplierRecord.setRestockDate(LocalDate.now());
            supplierRecord.setQuantity(dto.getQuantity());
            SupplierRecord saveRecord = supplierRecordRepository.save(supplierRecord);

            updateProductQuantity(product,dto.getQuantity());

            SupplierRecordDTO responseDto = new SupplierRecordDTO();
            responseDto.setSupplierRecordId(saveRecord.getSupplierRecordId());
            responseDto.setSupplierId(saveRecord.getSupplier().getSupplierId());
            responseDto.setProductId(saveRecord.getProduct().getProductId());
            responseDto.setRestockDate(saveRecord.getRestockDate());
            responseDto.setQuantity(saveRecord.getQuantity());
            return responseDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateProductQuantity(Product product, int quantity) {
        int currentStock = product.getProductQty();

        product.setProductQty(currentStock + quantity);
        productRepository.save(product);
    }
}

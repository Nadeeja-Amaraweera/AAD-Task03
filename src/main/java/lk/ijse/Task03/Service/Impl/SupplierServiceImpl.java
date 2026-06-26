package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.SupplierDTO;
import lk.ijse.Task03.Entity.Supplier;
import lk.ijse.Task03.Repository.SupplierRepository;
import lk.ijse.Task03.Service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        log.info("SupplierServiceImpl - saveSupplier() called");
        try {

            Supplier supplier = new Supplier();
            supplier.setSupplierName(supplierDTO.getSupplierName());
            supplier.setSupplierAddress(supplierDTO.getSupplierAddress());
            log.info("SupplierServiceImpl - saveSupplier() - Supplier entity created: {}", supplier);
            Supplier saveSupplier = supplierRepository.save(supplier);
            log.info("SupplierServiceImpl - saveSupplier() - Supplier saved: {}", saveSupplier);

            SupplierDTO responseDTO = new SupplierDTO();
            responseDTO.setSupplierId(saveSupplier.getSupplierId());
            responseDTO.setSupplierName(saveSupplier.getSupplierName());
            responseDTO.setSupplierAddress(saveSupplier.getSupplierAddress());
            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) {
        log.info("SupplierServiceImpl - updateSupplier() called");
        try {

            Optional<Supplier> optionalSupplier = supplierRepository.findById(supplierDTO.getSupplierId());

            if (!optionalSupplier.isPresent()){
                throw new RuntimeException("Supplier not found with id: " + supplierDTO.getSupplierId());
            }

            Supplier supplier = optionalSupplier.get();
            supplier.setSupplierName(supplierDTO.getSupplierName());
            supplier.setSupplierAddress(supplierDTO.getSupplierAddress());
            Supplier updatedSupplier = supplierRepository.save(supplier);

            SupplierDTO responseDTO = new SupplierDTO();
            responseDTO.setSupplierId(updatedSupplier.getSupplierId());
            responseDTO.setSupplierName(updatedSupplier.getSupplierName());
            responseDTO.setSupplierAddress(updatedSupplier.getSupplierAddress());
            return responseDTO;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package lk.ijse.Task03.Service.Impl;

import lk.ijse.Task03.DTO.CustomerDTO;
import lk.ijse.Task03.Entity.Customer;
import lk.ijse.Task03.Repository.CustomerRepository;
import lk.ijse.Task03.Service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("Customer save called");
        try {
            Customer customer = new Customer();
            customer.setCustomerName(customerDTO.getCustomerName());

            Customer saveCustomer = customerRepository.save(customer);

            CustomerDTO responseDTO = new CustomerDTO();
            responseDTO.setCustomerId(saveCustomer.getCustomerId());
            responseDTO.setCustomerName(saveCustomer.getCustomerName());

            return responseDTO;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

package furama.service;

import furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(String id);
    void remove(String id);
}

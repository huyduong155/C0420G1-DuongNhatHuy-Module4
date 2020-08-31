package codegym.customer.service;

import codegym.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface CustomerService {
    Page<Customer> findAll(String name,Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}

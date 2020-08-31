package furama.service;

import furama.model.Customer;
import furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);
    void save(Service service);
    Service findById(String id);
    void remove(String id);
}

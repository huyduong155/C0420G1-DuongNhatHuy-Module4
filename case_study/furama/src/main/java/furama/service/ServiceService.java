package furama.service;

import furama.model.Customer;
import furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Page<Service> findAll(String search,Pageable pageable);
    List<Service> findAll();
    void save(Service service);
    Service findById(String id);
    void remove(String id);
}

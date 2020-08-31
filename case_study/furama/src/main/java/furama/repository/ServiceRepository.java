package furama.repository;

import furama.model.Customer;
import furama.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServiceRepository extends JpaRepository<Service,String> {
    Page<Service> findAll(Pageable pageable);
}

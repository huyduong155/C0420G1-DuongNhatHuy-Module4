package furama.repository;

import furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{
    @Query(value = "select * from customer where name like %:keyword% or address like %:keyword% or phone_number like %:keyword%",nativeQuery = true)
    Page<Customer> findAllByAll(@Param("keyword") String keyword, Pageable pageable);
    //    List<Customer> findCustomerByAll(@Param("keyword") String keyword);


}

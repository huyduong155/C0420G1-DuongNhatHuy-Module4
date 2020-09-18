package smartPhone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import smartPhone.model.Smartphone;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}

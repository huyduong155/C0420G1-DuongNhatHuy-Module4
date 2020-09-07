package furama.service;

import furama.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    void save(Contract contract);
    List<Contract> findAll();
    Page<Contract> findAllCusUseSer(Pageable pageable);
}

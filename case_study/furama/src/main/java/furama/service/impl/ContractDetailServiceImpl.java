package furama.service.impl;

import furama.repository.ContractDetailRepository;
import furama.service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
}

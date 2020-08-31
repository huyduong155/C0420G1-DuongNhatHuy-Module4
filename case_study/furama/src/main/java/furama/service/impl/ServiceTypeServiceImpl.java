package furama.service.impl;

import furama.model.ServiceType;
import furama.repository.ServiceTypeRepository;
import furama.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}

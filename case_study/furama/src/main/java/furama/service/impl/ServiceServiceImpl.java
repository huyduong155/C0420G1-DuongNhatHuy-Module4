package furama.service.impl;

import furama.repository.ServiceRepository;
import furama.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Page<furama.model.Service> findAll(String search,Pageable pageable) {
        return serviceRepository.findAllByAll(search,pageable);
    }

    @Override
    public List<furama.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(furama.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public furama.model.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }
}

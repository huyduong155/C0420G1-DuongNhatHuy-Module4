package codegym.customer.service;

import codegym.customer.model.Customer;
import codegym.customer.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAllProvince();
}

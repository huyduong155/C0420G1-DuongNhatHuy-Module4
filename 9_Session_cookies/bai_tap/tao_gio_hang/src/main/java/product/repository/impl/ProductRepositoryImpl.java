package product.repository.impl;

import org.springframework.stereotype.Repository;
import product.model.Product;
import product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer,Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"Giay","new",16));
        productMap.put(2,new Product(2,"Dep","new",20));
        productMap.put(3,new Product(3,"Ao","new",19));
        productMap.put(4,new Product(4,"Quan","new",20));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}

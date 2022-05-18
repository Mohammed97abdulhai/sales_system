package application.persistence.repositories;

import application.persistence.entities.Product;

import java.util.List;

public interface ProductRepo {

    Product add(Product product);

    Product find(Long id);

    List<Product> findAll(Integer pageNo, Integer pageLimit);

    boolean exists(Long id);

}

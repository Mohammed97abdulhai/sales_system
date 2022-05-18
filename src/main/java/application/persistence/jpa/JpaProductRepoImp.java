package application.persistence.jpa;

import application.exceptions.ResourceNotFound;
import application.persistence.crud.ProductCrud;
import application.persistence.entities.Product;
import application.persistence.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JpaProductRepoImp implements ProductRepo {

    ProductCrud productCrud;


    @Override
    public Product add(Product product) {
        return productCrud.save(product);
    }

    @Override
    public Product find(Long id) {
        return productCrud.findById(id).orElseThrow(() -> new ResourceNotFound("product doesn't exist"));
    }

    @Override
    public List<Product> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return productCrud.findAll(pageable).getContent();
    }

    @Override
    public boolean exists(Long id) {
        return productCrud.existsById(id);
    }

}

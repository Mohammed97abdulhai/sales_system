package application.services;

import application.persistence.entities.Product;
import application.persistence.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts(Integer pageNo, Integer pageSize){
        return productRepo.findAll(pageNo, pageSize);
    }

    public Product addProduct(Product product){
        return productRepo.add(product);
    }

    public Object updateProduct(Long productId, Product updatedProduct){
        Product oldProduct = productRepo.find(productId);
        oldProduct.setCategory(updatedProduct.getCategory())
                .setDescription(updatedProduct.getDescription())
                .setName(updatedProduct.getName())
                .setCreationDate(updatedProduct.getCreationDate());
        return productRepo.add(oldProduct);
    }

}

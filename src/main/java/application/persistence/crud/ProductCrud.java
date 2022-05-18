package application.persistence.crud;

import application.persistence.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductCrud extends PagingAndSortingRepository<Product, Long> {
}

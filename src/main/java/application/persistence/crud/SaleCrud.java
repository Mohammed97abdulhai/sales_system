package application.persistence.crud;

import application.persistence.entities.Sale;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SaleCrud extends PagingAndSortingRepository<Sale, Long> {

}

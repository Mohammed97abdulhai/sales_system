package application.persistence.crud;

import application.persistence.entities.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientCrud extends PagingAndSortingRepository<Client, Long> {
}

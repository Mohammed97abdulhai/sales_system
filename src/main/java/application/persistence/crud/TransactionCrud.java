package application.persistence.crud;

import application.persistence.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionCrud extends PagingAndSortingRepository<Transaction, Long> {
}

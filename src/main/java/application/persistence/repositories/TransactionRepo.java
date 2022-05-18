package application.persistence.repositories;

import application.persistence.entities.Transaction;

public interface TransactionRepo {

    Transaction add(Transaction transaction);

    Transaction find(Long id);
}

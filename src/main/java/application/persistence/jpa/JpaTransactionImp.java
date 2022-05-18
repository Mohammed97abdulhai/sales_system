package application.persistence.jpa;

import application.exceptions.ResourceNotFound;
import application.persistence.crud.TransactionCrud;
import application.persistence.entities.Transaction;
import application.persistence.repositories.TransactionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaTransactionImp implements TransactionRepo {

    @Autowired
    TransactionCrud transactionCrud;

    @Override
    public Transaction add(Transaction transaction) {
        return transactionCrud.save(transaction);
    }

    @Override
    public Transaction find(Long id) {
        return transactionCrud.findById(id).orElseThrow(() -> new ResourceNotFound("transaction doesn't exist"));
    }
}

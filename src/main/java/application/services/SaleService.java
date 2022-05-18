package application.services;

import application.dtos.SaleDTO;
import application.dtos.UpdateTransactionDTO;
import application.persistence.entities.Sale;
import application.persistence.entities.Transaction;
import application.persistence.repositories.SaleRepo;
import application.persistence.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepo saleRepo;
    @Autowired
    TransactionRepo transactionRepo;

    public Object addSale(SaleDTO saleDTO){
        Sale sale = saleRepo.add(saleDTO.toEntity());
        saleDTO.getTransactions().forEach(trans -> {
            Transaction transaction = trans.toEntity();
            transaction.setSale(sale);
            transactionRepo.add(transaction);
        });
        return sale;
    }

    public List<Sale> getAllSales(Integer pageNo, Integer pageSize){
        return saleRepo.findAll(pageNo, pageSize);
    }

    public Transaction updateTransaction(UpdateTransactionDTO dto, Long saleId, Long transID) {
        saleRepo.find(saleId);
        Transaction transaction = transactionRepo.find(transID);

        transaction.setQuantity(dto.getQuantity());

        return transactionRepo.add(transaction);


    }
}

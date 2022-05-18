package application.dtos;

import application.persistence.entities.Transaction;
import lombok.Data;

@Data
public class TransactionDTO{
        public String product;
        public Integer quantity;
        Long saleId;

        public Transaction toEntity(){
            return new Transaction(this.product, this.quantity);
        }
    }
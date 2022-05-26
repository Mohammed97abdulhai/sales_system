package application.persistence.entities;

import lombok.Data;


@Data
public class TransactionLog {

    Long saleId;
    Long transactionId;
    Integer quantityBeforeUpdate;
    Integer quantityAfterUpdate;
    Integer priceBeforeUpdate;
    Integer priceAfterUpdate;

}

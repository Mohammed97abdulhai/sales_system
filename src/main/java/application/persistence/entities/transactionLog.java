package application.persistence.entities;

import lombok.Data;

import javax.persistence.Entity;


@Data
public class transactionLog {

    Long saleId;
    Long transactionId;
    Integer quantityBeforeUpdate;
    Integer quantityAfterUpdate;
    Integer PriceBeforeUpdate;
    Integer PriceAfterUpdate;

}

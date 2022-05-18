package application.dtos;

import application.persistence.entities.Sale;
import application.persistence.entities.Transaction;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class SaleDTO {

    Date creationDate;
    @NotNull
    Integer clientID;
    String seller;
    Long total;
    List<TransactionDTO> transactions;



    public Sale toEntity(){
        return new Sale(this.creationDate, this.clientID, this.seller, this.total);
    }
}

package application.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Date creationDate;

    Integer clientId;

    String seller;

    Long total;

    @OneToMany(mappedBy="sale")
    @JsonIgnore
    private Set<Transaction> transactions;

    public Sale(Date creationDate, Integer clientId, String seller, Long total) {
        this.creationDate = creationDate;
        this.clientId = clientId;
        this.seller = seller;
        this.total = total;
    }
}

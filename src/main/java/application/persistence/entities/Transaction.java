package application.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String product;

    Integer quantity;

    @ManyToOne
    @JoinColumn(name="sale_id", nullable=false)
    Sale sale;

    public Transaction(String product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

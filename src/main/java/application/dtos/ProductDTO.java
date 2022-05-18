package application.dtos;

import application.persistence.entities.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductDTO {

    @NotNull
    String name;
    String description;
    String category;
    Date createdDate;

    public Product toEntity(){
        return new Product(this.name, this.description, this.category, this.createdDate);
    }

}

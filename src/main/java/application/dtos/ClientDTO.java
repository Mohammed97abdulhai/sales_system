package application.dtos;

import application.persistence.entities.Client;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class ClientDTO {
    Long id;

    @NotNull
    String name;
    @NotNull
    String lastName;
    @Pattern(regexp = "([0-9]*)", message = "mobile number should contain numbers only")
    @Size(min = 9, max = 24, message = "number should be in the range 9 - 24")
    public String mobileNumber;

    public Client toEntity(){
        return new Client(this.name, this.lastName, this.mobileNumber);

    }
}

package application.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String lastName;

    String mobileNumber;

    public Client(String name, String lastName, String mobileNumber) {
        this.name = name;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }
}

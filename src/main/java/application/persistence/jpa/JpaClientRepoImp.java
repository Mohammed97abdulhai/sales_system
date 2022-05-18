package application.persistence.jpa;

import application.exceptions.ResourceNotFound;
import application.persistence.crud.ClientCrud;
import application.persistence.entities.Client;
import application.persistence.repositories.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JpaClientRepoImp implements ClientRepo {

    ClientCrud clientCrud;

    @Override
    public Client add(Client client) {
        return clientCrud.save(client);
    }

    @Override
    public Client find(Long id) {
        return clientCrud.findById(id).orElseThrow(() -> new ResourceNotFound("client doesn't exist"));
    }



    @Override
    public List<Client> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return clientCrud.findAll(pageable).getContent();
    }
}

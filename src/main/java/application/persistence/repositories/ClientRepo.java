package application.persistence.repositories;

import application.persistence.entities.Client;

import java.util.List;

public interface ClientRepo {

    Client add(Client client);

    Client find(Long id);

    List<Client> findAll(Integer pageNo, Integer pageLimit);


}

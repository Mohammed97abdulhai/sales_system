package application.services;

import application.persistence.entities.Client;
import application.persistence.repositories.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    ClientRepo clientRepo;

    public Client add(Client client){
        return clientRepo.add(client);
    }

    public List<Client> getAllClient(Integer page, Integer limit){
        return clientRepo.findAll(page, limit);
    }

    public Client update(Long clientId, Client updatedClient){
        Client oldClient = clientRepo.find(clientId);
        oldClient.setName(updatedClient.getName())
                .setLastName(updatedClient.getLastName())
                .setMobileNumber(updatedClient.getMobileNumber());
        return clientRepo.add(oldClient);
    }
}

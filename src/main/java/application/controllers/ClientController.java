package application.controllers;

import application.dtos.ClientDTO;
import application.exceptions.ValidationError;
import application.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static application.util.FormatterUtil.toMap;


@RestController
@RequestMapping("v1/clients")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping()
    public Object getAllClients(@RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
                                @RequestParam(required = false, name = "limit", defaultValue = "10") Integer limit) {
        return toMap("clients", clientService.getAllClient(page, limit));
    }


    @PostMapping
    public Object addClient(@RequestBody @Valid ClientDTO clientDTO, BindingResult errors) {
        if (errors.hasErrors())
            throw new ValidationError(errors);
        return toMap("client", clientService.add(clientDTO.toEntity()));
    }

    @PutMapping("/{client_id}")
    public Object updateClient(@PathVariable(name = "client_id") Long clientId,
                               @RequestBody ClientDTO clientDTO) {
        return toMap("new_client", clientService.update(clientId, clientDTO.toEntity()));
    }
}

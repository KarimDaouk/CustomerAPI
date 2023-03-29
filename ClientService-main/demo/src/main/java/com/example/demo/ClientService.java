package com.example.demo;

import com.google.i18n.phonenumbers.NumberParseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final Numverify numverify;

    public ClientService(ClientRepository clientRepository, Numverify numverify) {
        this.clientRepository = clientRepository;
        this.numverify = numverify;
    }



    public List<Client> getClient(){
        return clientRepository.findAll();
    }




    public void addClient(ClientController.NewClientRequest request) throws NumberParseException {
        if(numverify.validate(request.Number())) {
            Client client = new Client();
            client.setId(request.id());
            client.setName(request.name());
            client.setNumber(request.Number());

            clientRepository.save(client);
        }
    }

    public void deleteClient( Integer id){
        clientRepository.deleteById(id);
    }


    public void updateClient(@PathVariable("clientId")  Integer id, @RequestBody ClientController.NewClientRequest request){
        Client client= clientRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Client not found with id"+ id));
        client.setNumber(request.Number());
        client.setName(request.name());
        client.setId(id);
        clientRepository.deleteById(id);
        clientRepository.save(client);

    }
}

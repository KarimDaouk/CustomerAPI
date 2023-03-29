package com.example.demo;

import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {


    private final ClientService clientService;
    private final Numverify numverify;
    public ClientController(ClientService clientService, Numverify numverify) {
        this.clientService = clientService;
        this.numverify = numverify;
    }


    //JSON DATA
    public record NewClientRequest(
            Integer id,
            String name,
            String Number
    ){ }















    @GetMapping
    public List<Client> getClient(){
        return  clientService.getClient();
    }

    @PostMapping
    public void addClient(@RequestBody NewClientRequest request) throws NumberParseException {
        clientService.addClient(request);

    }

    @DeleteMapping("{clientId}")
    public void deleteClient(@PathVariable("clientId")  Integer id){
        clientService.deleteClient(id);
    }


    @PutMapping("{clientId}")

    public void updateClient(@PathVariable("clientId")  Integer id, @RequestBody ClientController.NewClientRequest request) {

        clientService.updateClient(id,request);
    }




}

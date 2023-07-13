package ru.BaymuhanovN.telegrambot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.BaymuhanovN.telegrambot.entities.Client;
import ru.BaymuhanovN.telegrambot.entities.ClientOrder;
import ru.BaymuhanovN.telegrambot.entities.Product;
import ru.BaymuhanovN.telegrambot.service.ClientService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/rest/clients")
public class ClientRestController {
    private final ClientService clientService;
    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients()
    {
        return clientService.getClients();
    }
    @GetMapping(path = "/{id}")
    public Client getClient(@PathVariable Long id)
    {
        return clientService.getClient(id);
    }
    @PostMapping(path = "/{id}/orders")
    public Long createClientOrder(@PathVariable Long id, @RequestBody Map<String, Object> input) {
        Double total = ((Number) input.get("total")).doubleValue();
        return clientService.createClientOrder(id, total);
    }

    @GetMapping(path = "/{id}/orders")
    public List<ClientOrder> getClientOrders(@PathVariable Long id) {
        return clientService.getClientOrders(id);
    }

    @GetMapping(path = "/{id}/products")
    public List<Product> getClientProducts(@PathVariable Long id)
    {
        return clientService.getClientProducts(id);
    }

    @GetMapping(path ="/{id}/orders/count")
    public Long countClientOrders(@PathVariable Long id )
    {
        return clientService.countClientOrders(id);
    }
}

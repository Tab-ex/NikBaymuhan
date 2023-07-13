package ru.BaymuhanovN.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BaymuhanovN.telegrambot.entities.Client;
import ru.BaymuhanovN.telegrambot.entities.ClientOrder;
import ru.BaymuhanovN.telegrambot.entities.Product;
import ru.BaymuhanovN.telegrambot.repositories.ClientOrderRepository;
import ru.BaymuhanovN.telegrambot.repositories.ClientRepository;
import ru.BaymuhanovN.telegrambot.repositories.ProductRepository;

import java.util.List;


@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientOrderRepository clientOrderRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientOrderRepository clientOrderRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.clientOrderRepository = clientOrderRepository;
    }

    public List<Client> getClients()
    {
        return clientRepository.findAll();
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public Long createClientOrder(Long id, Double total) {
        Client client =getClient(id);
        ClientOrder order = new ClientOrder();
        order.setClient(client);
        order.setTotal(total);
        order.setStatus(1);
        return clientOrderRepository.save(order).getId();
    }
    public Long countClientOrders(Long id) {
        return clientOrderRepository.countClientOrders(id);
    }

    public List<ClientOrder> getClientOrders(Long id) {
        return clientOrderRepository.findByClientId(id);
    }

    public List<Product> getClientProducts(Long clientId) {
        return clientRepository.getAllProduct(clientId);
    }

    public Client getClientByExternalId(Long externalId) {
        return clientRepository.findByExternalId(externalId);
    }
}

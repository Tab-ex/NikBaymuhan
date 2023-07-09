package ru.BaymuhanovN.telegrambot.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.ClientOrder;


@RepositoryRestResource(collectionResourceRel =
        "clientOrders", path = "clientOrders")
public interface ClientOrderRepository extends
        CrudRepository<ClientOrder, Long>
{
}

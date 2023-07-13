package ru.BaymuhanovN.telegrambot.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.ClientOrder;

import java.util.List;

@RepositoryRestResource(collectionResourceRel =
        "clientOrders", path = "clientOrders")
public interface ClientOrderRepository extends
        CrudRepository<ClientOrder, Long>
{
    @Query("select count(*) from ClientOrder co where co.client.id = :id")
    Long countClientOrders(Long id);

    List<ClientOrder> findByClientId(Long clientId);
}

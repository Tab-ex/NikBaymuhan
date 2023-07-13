package ru.BaymuhanovN.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.Client;
import ru.BaymuhanovN.telegrambot.entities.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel =
        "clients", path = "clients")
public interface ClientRepository extends
        JpaRepository<Client, Long>
{
    @Query("SELECT DISTINCT op.product FROM OrderProduct op WHERE op.clientOrder.client.id = :clientId")
    List<Product> getAllProduct(@Param("clientId") Long clientId);

    Client findByExternalId(Long externalId);
}

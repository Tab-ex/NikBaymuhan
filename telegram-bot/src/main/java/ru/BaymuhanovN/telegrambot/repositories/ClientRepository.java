package ru.BaymuhanovN.telegrambot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.Client;


@RepositoryRestResource(collectionResourceRel =
        "clients", path = "clients")
public interface ClientRepository extends
        CrudRepository<Client, Long>
{
}

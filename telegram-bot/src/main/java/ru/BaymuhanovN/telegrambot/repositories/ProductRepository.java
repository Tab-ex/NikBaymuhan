package ru.BaymuhanovN.telegrambot.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.Product;

@RepositoryRestResource(collectionResourceRel =
        "products", path = "products")
public interface ProductRepository extends
        CrudRepository<Product, Long>
{
}

package ru.BaymuhanovN.telegrambot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.OrderProduct;

@RepositoryRestResource(collectionResourceRel =
        "orderProducts", path = "orderProducts")
public interface OrderProductRepository extends
        CrudRepository<OrderProduct, Long>
{

}

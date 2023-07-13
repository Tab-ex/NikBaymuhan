package ru.BaymuhanovN.telegrambot.repositories;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.Product;

import java.util.List;

@RepositoryRestResource(collectionResourceRel =
        "products", path = "products")
public interface ProductRepository extends
        CrudRepository<Product, Long>
{
    List<Product> findByCategoryId(Long categoryId);

    @Query("SELECT op.product FROM OrderProduct op GROUP BY op.product.id ORDER BY SUM(op.countProduct) DESC")
    List<Product> findTopPopularProducts(Pageable pageable);
}

package ru.BaymuhanovN.telegrambot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.BaymuhanovN.telegrambot.entities.Category;

@RepositoryRestResource(collectionResourceRel =
        "categories", path = "categories")
public interface CategoryRepository extends
        CrudRepository<Category, Long>
{
}

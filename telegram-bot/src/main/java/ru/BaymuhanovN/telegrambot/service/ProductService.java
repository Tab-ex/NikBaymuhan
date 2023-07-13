package ru.BaymuhanovN.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.BaymuhanovN.telegrambot.entities.Product;
import ru.BaymuhanovN.telegrambot.repositories.OrderProductRepository;
import ru.BaymuhanovN.telegrambot.repositories.ProductRepository;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, OrderProductRepository orderProductRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getTopPopularProducts(Integer limit) {
        return productRepository.findTopPopularProducts(PageRequest.of(0, limit));
    }


}
package ru.BaymuhanovN.telegrambot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.BaymuhanovN.telegrambot.entities.Product;
import ru.BaymuhanovN.telegrambot.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/products")
public class ProductRestController {
    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/search")
    public List<Product> searchProductsByCategory(@RequestParam Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    @GetMapping(path = "/popular")
    public List<Product> getTopPopularProducts(@RequestParam Integer limit) {
        return productService.getTopPopularProducts(limit);
    }

}

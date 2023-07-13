package ru.BaymuhanovN.telegrambot.entities;

import javax.persistence.*;

@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private ClientOrder clientOrder;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Long countProduct;

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Long countProduct) {
        this.countProduct = countProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package ru.BaymuhanovN.telegrambot.entities;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String name;
    @ManyToOne
    private Category parent;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}

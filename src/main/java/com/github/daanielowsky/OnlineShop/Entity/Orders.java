package com.github.daanielowsky.OnlineShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor @NoArgsConstructor @Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Item> items;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postcode;

    @Column(nullable = false)
    private String city;

}

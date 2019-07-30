package com.github.daanielowsky.OnlineShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@AllArgsConstructor @NoArgsConstructor @Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private User user;

    @ManyToMany
    private List<Items> items;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postcode;

    @Column(nullable = false)
    private String city;

}

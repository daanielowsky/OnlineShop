package com.github.daanielowsky.OnlineShop.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data @RequiredArgsConstructor
public class ShoppingCartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Item item;

    private Long Quantity;
}

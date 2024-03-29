package com.github.daanielowsky.OnlineShop.Entity;

import com.github.daanielowsky.OnlineShop.DTO.ItemDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data @RequiredArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> shoppingCartItemsList;

    @OneToOne
    private User user;

}

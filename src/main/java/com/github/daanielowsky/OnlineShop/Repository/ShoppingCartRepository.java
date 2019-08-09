package com.github.daanielowsky.OnlineShop.Repository;

import com.github.daanielowsky.OnlineShop.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository <ShoppingCart, Long> {
}

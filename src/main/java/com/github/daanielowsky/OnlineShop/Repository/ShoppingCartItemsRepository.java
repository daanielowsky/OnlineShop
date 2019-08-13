package com.github.daanielowsky.OnlineShop.Repository;

import com.github.daanielowsky.OnlineShop.Entity.ShoppingCartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartItemsRepository extends JpaRepository <ShoppingCartItems, Long> {
}

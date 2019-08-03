package com.github.daanielowsky.OnlineShop.Repository;

import com.github.daanielowsky.OnlineShop.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository <Item, Long> {
}

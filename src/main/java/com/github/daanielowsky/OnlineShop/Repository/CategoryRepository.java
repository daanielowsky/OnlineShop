package com.github.daanielowsky.OnlineShop.Repository;

import com.github.daanielowsky.OnlineShop.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository <Category, Long> {

    Category getByName(String name);
}

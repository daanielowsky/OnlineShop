package com.github.daanielowsky.OnlineShop.Repository;

import com.github.daanielowsky.OnlineShop.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}

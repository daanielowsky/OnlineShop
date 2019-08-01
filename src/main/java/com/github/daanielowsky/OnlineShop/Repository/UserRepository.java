package com.github.daanielowsky.OnlineShop.Repository;

import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findFirstByUsername(String username);
    UserDTO findUserByUsername(String username);
}

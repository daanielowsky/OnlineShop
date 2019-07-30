package com.github.daanielowsky.OnlineShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private Long numberOfOrders;

    @OneToMany
    private List<Orders> Orders;

    private LocalDate created;

    @PrePersist
    public void prePersist(){
        created = LocalDate.now();
    }



}

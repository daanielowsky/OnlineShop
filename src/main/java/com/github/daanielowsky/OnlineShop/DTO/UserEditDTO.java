package com.github.daanielowsky.OnlineShop.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor @Data
public class UserEditDTO {

    @NotNull
    private String firstname;

    @NotNull
    private String surname;

    @NotNull @Email
    private String email;
}

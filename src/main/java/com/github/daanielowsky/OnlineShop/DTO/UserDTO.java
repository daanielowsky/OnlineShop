package com.github.daanielowsky.OnlineShop.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor @Data
public class UserDTO {

    @NotNull @Size(min = 5, max = 12)
    private String username;

    @NotNull @Size(min = 5, max = 15)
    private String password;

    @NotNull @Size(min = 5, max = 15)
    private String confirmedPassword;

    @NotNull
    private String firstname;

    @NotNull
    private String surname;

    @NotNull @Email
    private String email;
}

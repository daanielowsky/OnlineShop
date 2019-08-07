package com.github.daanielowsky.OnlineShop.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor @Data
public class PasswordChangeDTO {

    @NotNull @Size(min = 5, max = 15)
    private String oldPassword;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;

    @NotNull @Size(min = 5, max = 15)
    private String confirmedPassword;
}

package com.github.daanielowsky.OnlineShop.DTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;

@RequiredArgsConstructor @Data
public class CategoryDTO {

    @Size(min = 3, max = 20)
    private String name;
}

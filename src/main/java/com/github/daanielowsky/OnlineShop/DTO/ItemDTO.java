package com.github.daanielowsky.OnlineShop.DTO;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;

@RequiredArgsConstructor @Data
public class ItemDTO {

    @Size(min = 3)
    private String name;

    private Double price;

    private String description;

    private Long avaiability;

    private String categoryName;

    private String contentType;

    private byte[] image;
}

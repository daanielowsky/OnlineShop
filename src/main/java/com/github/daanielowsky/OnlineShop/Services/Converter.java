package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.ItemDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.Category;
import com.github.daanielowsky.OnlineShop.Entity.Item;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Repository.CategoryRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Converter {

    private PasswordEncoder passwordEncoder;

    public Converter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }

    public static User convertToUser(UserDTO userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        return user;
    }

    public static Category convertToCategory(CategoryDTO categorydto){
        Category category = new Category();
        category.setName(categorydto.getName());
        return category;
    }

    public static Item convertToItem(ItemDTO itemDTO){
        Item item = new Item();
        item.setAvaiability(itemDTO.getAvaiability());
        item.setDescription(itemDTO.getDescription());
        item.setImageType(itemDTO.getContentType());
        item.setFile(itemDTO.getImage());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        return item;

    }

    public static ItemDTO convertToItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setAvaiability(item.getAvaiability());
        itemDTO.setImage(item.getFile());
        itemDTO.setContentType(item.getImageType());
        return itemDTO;
    }

}

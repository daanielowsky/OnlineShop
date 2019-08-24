package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.ItemDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.Item;
import com.github.daanielowsky.OnlineShop.Entity.ShoppingCart;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BuyingController {

    private UserService userService;
    private CategoryService categoryService;
    private ItemsService itemsService;
    private ShoppingCartService shoppingCartService;

    public BuyingController(UserService userService, CategoryService categoryService, ItemsService itemsService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.itemsService = itemsService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/items/{name}")
    public String addItemToShoppingCart(@PathVariable String name) {
        User loggedUser = userService.getLoggedUser();
        if (loggedUser.getShoppingCart() == null) {
            shoppingCartService.createShoppingCart();
        }
        ShoppingCart shoppingCart = loggedUser.getShoppingCart();
        List<Item> shoppingCartItemsList = shoppingCart.getShoppingCartItemsList();
        ItemDTO itemToShow = itemsService.getItemToShow(name);
        shoppingCartItemsList.add(itemsService.getItemFromDTO(itemToShow));
        shoppingCartService.savingShoppingCart(shoppingCart);
        userService.saveCartForUser(shoppingCart);
        return "redirect:/items/" + name;

    }

    @ModelAttribute("userprofile")
    public UserDTO userFirstNameForTopSide() {
        User loggedUser = userService.getLoggedUser();
        if (loggedUser != null) {
            String firstname = loggedUser.getFirstname();
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstname(firstname);
            return userDTO;
        } else {
            return null;
        }
    }

    @ModelAttribute("categoriesDropdown")
    public List<CategoryDTO> dropdownOfCategories() {
        return categoryService.getListOfCategories();
    }

    private boolean checkIsUsernameAvaiable(UserDTO form) {
        UserDTO user = userService.findUser(form.getUsername());
        if (user == null) {
            return true;
        }
        return false;
    }
}

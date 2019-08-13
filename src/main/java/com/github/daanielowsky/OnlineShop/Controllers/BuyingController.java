package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.ShoppingCart;
import com.github.daanielowsky.OnlineShop.Entity.ShoppingCartItems;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Services.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuyingController {

    private UserService userService;
    private CategoryService categoryService;
    private ItemsService itemsService;
    private ShoppingCartService shoppingCartService;
    private ShoppingCartItemsService shoppingCartItemsService;

    public BuyingController(UserService userService, CategoryService categoryService, ItemsService itemsService, ShoppingCartService shoppingCartService, ShoppingCartItemsService shoppingCartItemsService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.itemsService = itemsService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartItemsService = shoppingCartItemsService;
    }

    @PostMapping("/items/{name}")
    public String addItemToShoppingCart(@PathVariable String name, @RequestParam("howMany") Long amount) {
        if (amount <= 0) {
            return "itemview";
        }
        User loggedUser = userService.getLoggedUser();
        if (loggedUser.getShoppingCart() == null) {
            shoppingCartService.createSaveShoppingCart();
            shoppingCartItemsService.addingNewItemToShoppingCart(name, amount);
        } else {
            ShoppingCart shoppingCart = loggedUser.getShoppingCart();
            for (ShoppingCartItems shoppingCartItems : shoppingCart.getShoppingCartItemsList()) {
                String nameOfSingleItem = shoppingCartItems.getItem().getName();
                if (nameOfSingleItem == name) {
                    Long quantity = shoppingCartItems.getQuantity();
                    shoppingCartItems.setQuantity(quantity + amount);
                } else {
                    shoppingCartItemsService.addingNewItemToShoppingCart(name, amount);
                }
            }
        }
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

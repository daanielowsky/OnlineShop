package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.ShoppingCart;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Services.CategoryService;
import com.github.daanielowsky.OnlineShop.Services.ItemsService;
import com.github.daanielowsky.OnlineShop.Services.ShoppingCartService;
import com.github.daanielowsky.OnlineShop.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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
    public String addItemToShoppingCart(@PathVariable String name, @RequestParam("howMany") Long amount) {
        if (amount<=0){
            return "itemview";
        }
        User loggedUser = userService.getLoggedUser();
        if (loggedUser.getShoppingCart() == null) {
            ShoppingCart shoppingCart = new ShoppingCart();
            loggedUser.setShoppingCart(shoppingCart);
            shoppingCart.setUser(loggedUser);
        } else {
            ShoppingCart shoppingCart = loggedUser.getShoppingCart();
            Map<String, Long> itemsInCart = shoppingCart.getItemsInCart();
            if (!itemsInCart.containsKey(name)) {
                itemsInCart.put(name, amount);
            } else {
                Long amountItemsThatAreAlreadyInCart = itemsInCart.get(name);
                Long newAmount = amountItemsThatAreAlreadyInCart + amount;
                itemsInCart.replace(name, amountItemsThatAreAlreadyInCart, newAmount);
            }
            shoppingCartService.createSaveShoppingCart(shoppingCart);
        }

        return "itemview";

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

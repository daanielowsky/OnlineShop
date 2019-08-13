package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.Entity.ShoppingCart;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;
    private UserService userService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, UserService userService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userService = userService;
    }


    public void createSaveShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        User loggedUser = userService.getLoggedUser();
        loggedUser.setShoppingCart(shoppingCart);
        shoppingCart.setUser(loggedUser);
        shoppingCartRepository.save(shoppingCart);
    }
}

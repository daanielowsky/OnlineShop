package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.Entity.ShoppingCart;
import com.github.daanielowsky.OnlineShop.Repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }


    public void createSaveShoppingCart(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }
}

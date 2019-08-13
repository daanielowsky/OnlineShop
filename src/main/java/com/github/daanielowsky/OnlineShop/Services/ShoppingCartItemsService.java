package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.Entity.Item;
import com.github.daanielowsky.OnlineShop.Entity.ShoppingCartItems;
import com.github.daanielowsky.OnlineShop.Repository.ItemsRepository;
import com.github.daanielowsky.OnlineShop.Repository.ShoppingCartItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartItemsService {

    private ShoppingCartItemsRepository shoppingCartItemsRepository;
    private ItemsRepository itemsRepository;

    public ShoppingCartItemsService(ShoppingCartItemsRepository shoppingCartItemsRepository, ItemsRepository itemsRepository) {
        this.shoppingCartItemsRepository = shoppingCartItemsRepository;
        this.itemsRepository = itemsRepository;
    }

    public void addingNewItemToShoppingCart(String name, Long quantity){
        ShoppingCartItems shoppingCartItems = new ShoppingCartItems();
        Item byName = itemsRepository.getByName(name);
        shoppingCartItems.setQuantity(quantity);
        shoppingCartItems.setItem(byName);
        shoppingCartItemsRepository.save(shoppingCartItems);
    }
}

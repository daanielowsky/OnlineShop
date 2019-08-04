package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.DTO.ItemDTO;
import com.github.daanielowsky.OnlineShop.Entity.Category;
import com.github.daanielowsky.OnlineShop.Entity.Item;
import com.github.daanielowsky.OnlineShop.Repository.CategoryRepository;
import com.github.daanielowsky.OnlineShop.Repository.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.daanielowsky.OnlineShop.Services.Converter.*;

@Service
public class ItemsService {

    private CategoryRepository categoryRepository;
    private ItemsRepository itemsRepository;

    public ItemsService(CategoryRepository categoryRepository, ItemsRepository itemsRepository) {
        this.categoryRepository = categoryRepository;
        this.itemsRepository = itemsRepository;
    }

    public void creatingItem(ItemDTO itemDTO){
        Item item = convertToItem(itemDTO);
        String categoryName = itemDTO.getCategoryName();
        Category itemsCategory = categoryRepository.getByName(categoryName);
        List<Item> itemsOfCategory = itemsCategory.getItems();
        itemsRepository.save(item);
        itemsOfCategory.add(item);
        categoryRepository.save(itemsCategory);
    }

}

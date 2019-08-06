package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.Entity.Category;
import com.github.daanielowsky.OnlineShop.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.github.daanielowsky.OnlineShop.Services.Converter.*;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void creatingCategory(CategoryDTO categoryDTO){
        Category category = convertToCategory(categoryDTO);
        categoryRepository.save(category);
    }

    public List<CategoryDTO> getListOfCategories(){
        List<Category> allCategories = categoryRepository.findAll();
        List categories = new ArrayList();
        for (Category fe :allCategories){
            String name = fe.getName();
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(name);
            categories.add(categoryDTO);
        }
        return categories;
    }

}

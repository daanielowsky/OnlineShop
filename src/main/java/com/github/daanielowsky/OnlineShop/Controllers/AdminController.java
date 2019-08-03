package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.ItemDTO;
import com.github.daanielowsky.OnlineShop.Entity.Category;
import com.github.daanielowsky.OnlineShop.Repository.CategoryRepository;
import com.github.daanielowsky.OnlineShop.Services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private ItemsService itemsService;

    public AdminController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/addcategory")
    public String formForNewCategory(Model model){
        model.addAttribute("category", new CategoryDTO());
        return "addcategory";
    }

    @PostMapping("/addcategory")
    public String creatingNewCategory(@Valid @ModelAttribute("category") CategoryDTO form, BindingResult result){
        if(result.hasErrors()){
            return "addcategory";
        }
        categoryService.creatingCategory(form);
        return "redirect:/profile";
    }

    @GetMapping("/additems")
    public String formForNewItems(Model model){
        model.addAttribute("item", new ItemDTO());
        model.addAttribute("categories", categoryRepository.findAll());
        return "additems";
    }

    @PostMapping("/additems")
        public String creatingNewItem(@Valid @ModelAttribute("item") ItemDTO itemDTO, BindingResult result, @RequestParam MultipartFile offerImage) throws IOException {

    }
}

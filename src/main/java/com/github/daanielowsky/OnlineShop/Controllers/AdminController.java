package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.Services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private CategoryService categoryService;

    public AdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
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
}

package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserEditDTO;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Services.CategoryService;
import com.github.daanielowsky.OnlineShop.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private UserService userService;
    private CategoryService categoryService;


    public ProfileController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String profileOptions(Model model){
        Long numberOfOrders = userService.getLoggedUser().getNumberOfOrders();
        model.addAttribute("orders", numberOfOrders);
        return "profile";
    }

    @GetMapping("/passwordchange")
    public String changePasswordForm(){
        return "passwordchange";
    }

    @GetMapping("/edit")
    public String profileEditForm(Model model){
        model.addAttribute("editUser", new UserEditDTO());
        return "profileedit";
    }

    @PostMapping("/edit")
    public String editingprofile(@Valid @ModelAttribute("editUser") UserEditDTO form, BindingResult result){
        if(result.hasErrors()){
            return "profileedit";
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(form.getEmail());
        userDTO.setFirstname(form.getFirstname());
        userDTO.setSurname(form.getSurname());
        userService.editUser(userDTO);
        return "redirect:/profile";
    }

    @ModelAttribute("userprofile")
    public UserDTO userFirstNameForTopSide(){
        User loggedUser = userService.getLoggedUser();
        if (loggedUser != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstname(loggedUser.getFirstname());
            userDTO.setSurname(loggedUser.getSurname());
            userDTO.setPassword(loggedUser.getPassword());
            userDTO.setEmail(loggedUser.getEmail());
            return userDTO;
        } else {
            return null;
        }
    }

    @ModelAttribute("categoriesDropdown")
    public List<CategoryDTO> dropdownOfCategories(){
        return categoryService.getListOfCategories();
    }
}

package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.CategoryDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Services.CategoryService;
import com.github.daanielowsky.OnlineShop.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomepageController {

    private UserService userService;
    private CategoryService categoryService;

    public HomepageController(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String homepageScreen(){
        return "homepage";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "loginpage";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new UserDTO());
        return "registerpage";
    }
    @PostMapping("/register")
    public String creatingTheUser(@Valid @ModelAttribute("user") UserDTO form, BindingResult result){
        if(result.hasErrors()){
            return "registerpage";
        }
        if (!checkPasswordEquality(form)) {
            result.rejectValue("confirmedPassword", null, "Hasło i powtórzone hasło nie są takie same.");
            return "registerpage";
        }

        if (!checkIsUsernameAvaiable(form)) {
            result.rejectValue("username", null, "Nazwa użytkownika już zajęta.");
            return "registerpage";
        }
        userService.registerUser(form);

        return "homepage";
    }

    @ModelAttribute("userprofile")
    public UserDTO userFirstNameForTopSide(){
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
    public List<CategoryDTO> dropdownOfCategories(){
        return categoryService.getListOfCategories();
    }

    private boolean checkIsUsernameAvaiable(UserDTO form) {
        UserDTO user = userService.findUser(form.getUsername());
        if (user == null){
            return true;
        }
        return false;
    }

    private boolean checkPasswordEquality(UserDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }
}

package com.github.daanielowsky.OnlineShop.Controllers;

import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
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
    public String profileEditForm(){
        return "profileedit";
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
}

package com.github.daanielowsky.OnlineShop.Services;

import com.github.daanielowsky.OnlineShop.DTO.PasswordChangeDTO;
import com.github.daanielowsky.OnlineShop.DTO.UserDTO;
import com.github.daanielowsky.OnlineShop.Entity.User;
import com.github.daanielowsky.OnlineShop.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.github.daanielowsky.OnlineShop.Services.Converter.*;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User getLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findFirstByUsername(username).orElse(null);
    }

    public void registerUser(UserDTO userDto) {
        User user = convertToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        logger.info(user.toString());
        userRepository.save(user);
    }

    public void editUser(UserDTO userDTO) {
        User loggedUser = getLoggedUser();
        loggedUser.setFirstname(userDTO.getFirstname());
        loggedUser.setSurname(userDTO.getSurname());
        loggedUser.setEmail(userDTO.getEmail());
        userRepository.save(loggedUser);
    }

    public void changePassword(String password){
        User loggedUser = getLoggedUser();
        logger.info(loggedUser.toString());
        String encodedPassword = passwordEncoder.encode(password);
        loggedUser.setPassword(encodedPassword);
        logger.info(loggedUser.toString());
        userRepository.save(loggedUser);
    }

    @Transactional
    public UserDTO findUser(String username) {
        if (username == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser  = userRepository.findFirstByUsername(username);
        User user = optionalUser.orElse(null);
        if (user == null) {
            logger.debug("Nie znaleziono użytkownika dla nazwy: " + username);
            return null;
        }
        logger.debug("Znaleziono użytkownika dla nazwy: " + username);
        return  convertToUserDTO(user);
    }
}

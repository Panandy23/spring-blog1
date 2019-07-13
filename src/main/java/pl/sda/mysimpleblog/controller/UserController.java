package pl.sda.mysimpleblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.mysimpleblog.model.User;
import pl.sda.mysimpleblog.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String addUser (Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/register")
    public String addUser (@ModelAttribute @Valid User user, BindingResult bindingResult, Model model){


        if(bindingResult.hasErrors()){
            return "adduser";
        }
       if(userService.passwordCheck(user.getPassword(), user.getPassword_confirm())) {
           userService.registerUser(user);

           return "redirect:/";
       }
    model.addAttribute("passwordMessage", "hasło nie pasuje");

       return "adduser";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    }





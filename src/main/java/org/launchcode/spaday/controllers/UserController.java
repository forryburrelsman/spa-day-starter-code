package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@Controller
public class UserController {


    @GetMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (verify.equals(user.getPassword())){
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }

}

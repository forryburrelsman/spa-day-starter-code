package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

//    @PostMapping
//    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
//        if (!verify.equals(user.getPassword())) {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }
//        if (errors.hasErrors()){
//            return "user/add";
//        }
//
//
//        return "user/index";
//        }

    //bonus
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
        if (errors.hasErrors()){
            return "user/add";
        }

        return "user/index";
    }


    }

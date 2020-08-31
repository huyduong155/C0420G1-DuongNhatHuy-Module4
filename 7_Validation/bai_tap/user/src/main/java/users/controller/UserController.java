package users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import users.model.User;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/")
    public String checkValidateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,Model model){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }else {
            model.addAttribute("user",user);
            return "result";
        }
    }
}

package jdanimal.demo.web.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class IndexController {

    //login page
    @GetMapping("/users/login")
    public String logIn(Model model){
        if(!model.containsAttribute("registeredSuccessfully")){
            model.addAttribute("registeredSuccessfully",true);
        }

        return "index";
    }

    //logout page
    @GetMapping("/logout")
    public String logOut() {
        return "index";
    }

    //access denied page
    @GetMapping("/access-denied")
    public String accessDeniedPage(){
        return "access-denied";
    }
}

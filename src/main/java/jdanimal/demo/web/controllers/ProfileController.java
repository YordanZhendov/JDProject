package jdanimal.demo.web.controllers;

import jdanimal.demo.service.UserService;
import jdanimal.demo.service.models.UserAnimalUploadModel;
import jdanimal.demo.service.models.UserProfileModel;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class ProfileController {

    private final UserService userService;


    @GetMapping("/profile")
    public String getUserProfile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            UserProfileModel userProfileInfo = userService.findByUsername(currentUserName);

            model.addAttribute("userProfileInfo",userProfileInfo);
            return "profile";
        }
        return null;
    }

    @GetMapping("/animaladd")
    public String addAnimal(Model model){
        if(!model.containsAttribute("userAnimalUploadModel")){
            model.addAttribute("userAnimalUploadModel",new UserAnimalUploadModel());
        }
        return "animaladd";
    }

    @PostMapping("/animal/upload")
    public String uploadAnimal(@Valid UserAnimalUploadModel userAnimalUploadModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute(
                    "userAnimalUploadModel",userAnimalUploadModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userAnimalUploadModel",bindingResult);
            return "redirect:/user/animaladd";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            UserProfileModel userProfileInfo = userService.findByUsername(currentUserName);

          this.userService.uploadAnimal(userAnimalUploadModel,userProfileInfo);
            return "redirect:/user/profile";
        }
        return null;
    }

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }

}

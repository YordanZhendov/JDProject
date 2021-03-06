package jdanimal.demo.web.controllers;

import jdanimal.demo.service.AccessoryService;
import jdanimal.demo.service.AnimalService;
import jdanimal.demo.service.views.AccessoryViewModel;
import jdanimal.demo.service.views.AnimalViewModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final AnimalService animalService;
    private final AccessoryService accessoryService;

    //Home, that shows All Animals and Accessories
    @GetMapping("/user/home")
    public String getHome(Model model){

        List<AnimalViewModel> allAnimals = this.animalService.getAllAnimals();
        List<AccessoryViewModel> allAccessories = this.accessoryService.getAllAccessories();

        model.addAttribute("accessories",allAccessories);
        model.addAttribute("animals",allAnimals);

        return "home";
    }

    //filter all Animals
    @GetMapping("/user/filterby/animals")
    public String filterbyAnimal(Model model){

        List<AnimalViewModel> allAnimals = this.animalService.getAllAnimals();

        model.addAttribute("animals",allAnimals);

        return "homebyanimals";
    };

    //filter all Accessories
    @GetMapping("/user/filterby/accessories")
    public String filterbyAccessory(Model model){

        List<AccessoryViewModel> allAccessories = this.accessoryService.getAllAccessories();

        model.addAttribute("accessories",allAccessories);

        return "homebyaccessories";
    };
}

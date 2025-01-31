package cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = {"/",""})
public class HomeController {

    @GetMapping(value = {"/",""})
    public String viewHomePage(Model model) {
        model.addAttribute("car");
        return "home";
    }

}

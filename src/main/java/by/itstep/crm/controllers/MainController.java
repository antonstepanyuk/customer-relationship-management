package by.itstep.crm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String home(
            @RequestParam String username,//TODO USER role parameter
            Model model) {
        model.addAttribute("username", username);
        return "main";
    }
}

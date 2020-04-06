package by.itstep.crm.controllers;

import by.itstep.crm.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registration(
            @RequestParam(name = "name", required = true)
                    String name,
            @RequestParam(name = "surname", required = true)

                    String surname,
            @RequestParam(name = "email", required = true)
                    String email,
            @RequestParam(name = "login", required = true)
                    String login,
            @RequestParam(name = "password", required = true)
                    String password,
            Model model//TODO what is it?
    ) {
        return "Ok";
    }
//    @GetMapping("/registration")
//    public String registration(
////            @RequestParam(name = "name", required = true)
////                    String name,
////            String surname,
////            Model model
//    ) {
////        model.addAttribute("name", name);
//
//        return "registration";
//    }
//
//    @GetMapping
//    public String main(Map<String, Object> model) {
//        model.put("some", "hello, let's code");
//        return "main";
}


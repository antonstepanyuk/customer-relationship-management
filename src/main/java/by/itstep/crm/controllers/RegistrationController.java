package by.itstep.crm.controllers;

import by.itstep.crm.models.Role;
import by.itstep.crm.models.User;
import by.itstep.crm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDatabase = userRepository.findByUsername(user.getUsername());
        if(userFromDatabase!=null){
            model.addAttribute("message","User exists!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.CUSTOMER));
        userRepository.save(user);
        return "redirect:/login";
    }
}


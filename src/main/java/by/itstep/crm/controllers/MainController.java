package by.itstep.crm.controllers;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Role;
import by.itstep.crm.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

import static by.itstep.crm.entities.Role.*;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(
//            @AuthenticationPrincipal UserDto userDto,
//            Model model
    ){
//        model.addAttribute("user",userDto);
        return "main";
    }

//    @GetMapping
//    public String main(
//            @AuthenticationPrincipal User user,//TODO USER role parameter
//            Model model) {
//        Set<Role> currentRole = user.getRole();
//        String page = null;
//        if (currentRole.contains(ADMINISTRATOR)) {
//            page = "administrator";
//        } else if (currentRole.contains(MANAGER)) {
//            page = "manager";
//        } else if (currentRole.contains(CUSTOMER)) {
//            page = "customer";
//        }
//        model.addAttribute("username", user.getUsername());
//        return "redirect:/" + page;
//    }
}
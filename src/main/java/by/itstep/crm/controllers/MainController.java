package by.itstep.crm.controllers;

import by.itstep.crm.models.Role;
import by.itstep.crm.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user,//TODO USER role parameter
            Model model) {
        Set<Role> currentRole = user.getRole();
        String page;
        if (currentRole.contains(Role.ADMINISTRATOR)) {
            page = Role.ADMINISTRATOR.name().toLowerCase();
        }else if(currentRole.contains(Role.MANAGER)) {
            page = Role.MANAGER.name().toLowerCase();
        }else {
            page = Role.CUSTOMER.name().toLowerCase();
        }

        model.addAttribute("username", user.getUsername());
        return "redirect:/" + page;


//        Set<Role> currentRole=user.getRole();
//        if (currentRole.contains(Role.ADMINISTRATOR)) {
//            model.addAttribute("username", user.getUsername());
//            return "redirect:/administrator";
//        }
//        if (currentRole.contains(Role.MANAGER)) {
//            model.addAttribute("username", user.getUsername());
//            return "redirect:/manager";
//        }
//        if(currentRole.contains(Role.CUSTOMER)){
//            model.addAttribute("username", user.getUsername());
//            return "redirect:/customer";
//        }
////        model.addAttribute("message", "Неверный тип пользователя");//Удалить
//        return "login";
    }
}

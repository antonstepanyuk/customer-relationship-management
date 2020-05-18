package by.itstep.crm.controllers;

import by.itstep.crm.entities.Role;
import by.itstep.crm.entities.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

import static by.itstep.crm.entities.Role.*;

@Controller
@RequestMapping("main")
@PreAuthorize("isAuthenticated()")
public class MainController {

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model) {
        Set<Role> role = user.getRole();
        //выдача контента по ролям
        if (role.contains(ADMINISTRATOR)) {
            //todo Model for user
        } else if (role.contains(MANAGER)) {
            //todo Model for user

        } else if (role.contains(CUSTOMER)) {
            //todo Model for user

        }
        return "main";
    }


}

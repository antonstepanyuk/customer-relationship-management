package by.itstep.crm.controllers;

import by.itstep.crm.models.Manager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
@PreAuthorize("hasAuthority('MANAGER')")
public class ManagerController {

    @GetMapping
    public String managerMain(
            @AuthenticationPrincipal Manager manager,
            Model model) {
        model.addAttribute("username", manager.getUsername());
        return "manager";
    }

    @GetMapping("/create_user")//????????????????????????????????????????
    public String userCreationForm() {
        return "userCreate";
    }

}


package by.itstep.crm.controllers;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Administrator;
import by.itstep.crm.entities.Role;
import by.itstep.crm.entities.User;
import by.itstep.crm.services.CustomerService;
import by.itstep.crm.services.ManagerService;
import by.itstep.crm.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static by.itstep.crm.entities.Role.*;

@Controller
@RequestMapping("/administrator")
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
public class AdministratorController {

    private final ManagerService managerService;
    private final CustomerService customerService;
    private final UserService userService;

    public AdministratorController(ManagerService managerService,
                                   CustomerService customerService,
                                   UserService userService) {
        this.managerService = managerService;
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("create_user")
    public String userCreationForm(Model model) {
        model.addAttribute("roles", Role.values());
        return "userCreate";
    }

    @PostMapping("create_user")//todo RENAME IN 1 WORD
    public String userCreate(
            UserDto userDto,
            Model model) {
        User userFromDatabase = (User) userService.loadUserByUsername(userDto.getUsername());
        if (userFromDatabase != null) {
            model.addAttribute("roles", Role.values());

            model.addAttribute("message", "Пользователь c таким именем уже существует! ");//todo CLASS!!!
            return "userCreate";
        }
        Set<Role> role = userDto.getRole();
        if (role.contains(MANAGER)) {
            managerService.createManager(userDto);
            return "main";
        } else if (role.contains(CUSTOMER)) {
            customerService.createCustomer(userDto);
            return "main";
        }
        model.addAttribute("message", "Пользователь не добавлен!");//todo CLASS!!!
        model.addAttribute("roles", Role.values());
        return "userCreate";
    }
}






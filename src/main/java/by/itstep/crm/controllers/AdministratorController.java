package by.itstep.crm.controllers;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Role;
import by.itstep.crm.services.CustomerService;
import by.itstep.crm.services.ManagerService;
import by.itstep.crm.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

import static by.itstep.crm.entities.Role.CUSTOMER;
import static by.itstep.crm.entities.Role.MANAGER;

@Controller
@RequestMapping("administrator")
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

    @GetMapping("create/user")
    public String userCreationForm(Model model) {
        model.addAttribute("roles", Role.values());
        return "userCreate";
    }

    @PostMapping("create/user")
    public String userCreate(UserDto dto, Model model) {
        if (userService.loadUserByUsername(dto.getUsername()) != null) {
            model.addAttribute("roles", Role.values());
//            model.addAttribute("message", "Пользователь c таким именем уже существует! ");//todo CLASS!!!
            return "redirect:/administrator/create/user";
        }
        Set<Role> role = dto.getRole();
        if (role.contains(MANAGER)) {
            managerService.create(dto);
            return "redirect:/main";
        } else if (role.contains(CUSTOMER)) {
            customerService.create(dto);
            return "redirect:/main";
        }
        model.addAttribute("roles", Role.values());
        //        model.addAttribute("message", "Пользователь не добавлен!");//todo CLASS!!!
        return "userCreate";
    }
}






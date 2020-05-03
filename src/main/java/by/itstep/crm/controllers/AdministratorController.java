package by.itstep.crm.controllers;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Administrator;
import by.itstep.crm.entities.Role;
import by.itstep.crm.entities.User;
import by.itstep.crm.services.AdministratorService;
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
    private final AdministratorService administratorService;
    private final ManagerService managerService;
    private final CustomerService customerService;
    private final UserService userService;

    public AdministratorController(AdministratorService administratorService,
                                   ManagerService managerService,
                                   CustomerService customerService,
                                   UserService userService) {
        this.administratorService = administratorService;
        this.managerService = managerService;
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping
    public String administratorMain(
            @AuthenticationPrincipal Administrator administrator,
            Model model) {
        model.addAttribute("username", administrator.getUsername());
        model.addAttribute("users", userService.loadAllUsers());
        return "administrator";
    }

    @GetMapping("create_user")
    public String userCreationForm(Model model) {
        model.addAttribute("roles", Role.values());
        return "userCreate";
    }

    @PostMapping("create_user")//todo RENAME IN 1 WORD
    public String userCreate(
            UserDto userDto,//todo Dto EVERYWHERE @REQUESTPARA???
            Model model) {
        User userFromDatabase = (User) userService.loadUserByUsername(userDto.getUsername());
        if (userFromDatabase != null) {
            model.addAttribute("roles", Role.values());
            model.addAttribute("message", "Пользователь c таким именем уже существует! ");//todo CLASS!!!
            return "userCreate";
        }
        Set<Role> role = userDto.getRole();
        if (role.contains(ADMINISTRATOR)) {
            administratorService.createAdministrator(userDto);
            model.addAttribute("message", "Пользователь успешно добавлен!");//todo CLASS!!!
            return "administrator";
        } else if (role.contains(MANAGER)) {
            managerService.createManager(userDto);
            model.addAttribute("message", "Пользователь успешно добавлен!");//todo CLASS!!!
            return "administrator";
        } else if (role.contains(CUSTOMER)) {
            customerService.createCustomer(userDto);
            model.addAttribute("message", "Пользователь успешно добавлен!");//todo CLASS!!!
            return "administrator";
        }
        model.addAttribute("message", "Пользователь не добавлен!");//todo CLASS!!!
        model.addAttribute("roles", Role.values());
        return "userCreate";
    }

//    @PostMapping("{user}")
//    public String userEditForm(
////            @PathVariable UserDto userDto,
//            @RequestParam Set<Role> role,
//            Model model) {
//        Set<Role> userRole = userDto.getRole();
//        if (userRole.contains(ADMINISTRATOR)) {
//            model.addAttribute("user", administratorService.loadUserByUsername(user.getUsername()));
//        } else if (userRole.contains(Role.MANAGER)) {
//            model.addAttribute("user", managerService.loadUserByUsername(user.getUsername()));
//
//        } else {
//            model.addAttribute("user", customerService.loadUserByUsername(user.getUsername()));
//        }
//        return "userEdit";
//    }

//    @PostMapping("/userEdit")
//    public String save() {
//        return "userEdit";//todo
//    }
}






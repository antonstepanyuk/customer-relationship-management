package by.itstep.crm.controllers;

import by.itstep.crm.models.*;
import by.itstep.crm.services.AdministratorService;
import by.itstep.crm.services.CustomerService;
import by.itstep.crm.services.ManagerService;
import by.itstep.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/administrator")
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;


    @GetMapping
    public String administratorMain(
            @AuthenticationPrincipal Administrator administrator,
            Model model) {
        model.addAttribute("username", administrator.getUsername());
        model.addAttribute("users", userService.loadAllUsers());
        return "administrator";
    }

    @GetMapping("/create_user")
    public String userCreationForm(Model model) {
        model.addAttribute("roles", Role.values());
        return "userCreate";
    }

    @PostMapping("/create_user")
    public String userCreate(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Set<Role> role,
            Model model) {
        User userFromDatabase = (User) userService.loadUserByUsername(username);
        if (userFromDatabase != null) {
            model.addAttribute("roles", Role.values());
            model.addAttribute("message", "Пользователь c таким именем уже существует! ");
            return "userCreate";
        }

        if (role.contains(Role.ADMINISTRATOR)) {
            Administrator administrator = new Administrator();

            administrator.setUsername(username);
            administrator.setPassword(password);
            administrator.setFirstName(firstName);
            administrator.setLastName(lastName);

            administratorService.save(administrator);

            model.addAttribute("message", "Пользователь успешно добавлен!");
            return "administrator";

        }

        if (role.contains(Role.MANAGER)) {
            Manager manager = new Manager();

            manager.setUsername(username);
            manager.setPassword(password);
            manager.setFirstName(firstName);
            manager.setLastName(lastName);

            managerService.save(manager);

            model.addAttribute("message", "Пользователь успешно добавлен!");
            return "administrator";

        }
        if (role.contains(Role.CUSTOMER)) {
            Customer customer = new Customer();

            customer.setUsername(username);
            customer.setPassword(password);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);

            customerService.save(customer);

            model.addAttribute("message", "Пользователь успешно добавлен!");
            return "administrator";

        }

        model.addAttribute("message", "Пользователь не добавлен!");
        return "userCreate";
    }

    @GetMapping("{user}")
    public String userEditForm(
            @PathVariable User user,
            Model model) {
        Set<Role> userRole = user.getRole();
        if (userRole.contains(Role.ADMINISTRATOR)) {
            model.addAttribute("user", administratorService.loadUserByUsername(user.getUsername()));

        } else if (userRole.contains(Role.MANAGER)) {
            model.addAttribute("user", managerService.loadUserByUsername(user.getUsername()));

        } else {
            model.addAttribute("user", customerService.loadUserByUsername(user.getUsername()));
        }
        return "userEdit";
    }

    @PostMapping("/userEdit")
    public String save() {
        return "userEdit";//todo
    }
}






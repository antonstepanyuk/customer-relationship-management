package by.itstep.crm.controllers;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Customer;
import by.itstep.crm.entities.User;
import by.itstep.crm.services.CustomerService;
import by.itstep.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;
    private final CustomerService customerService;

    public RegistrationController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping//todo USERNAME AND PASSWORD CHECK!!!!
    public String registration(
            UserDto userDto,
            Model model)    {
        User userFromDatabase= (User) userService.loadUserByUsername(userDto.getUsername());
        if (userFromDatabase != null) {
            model.addAttribute("message", "Пользователь с таким именем уже существует!");//todo MESSAGES!!!
            return "registration";
        }
        customerService.createCustomer(userDto);
        model.addAttribute("message", "Пользователь зарегистрирован, можете выполнить вход");//todo MESSAGES!!!
        return "login";
    }
}

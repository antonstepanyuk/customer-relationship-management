package by.itstep.crm.controllers;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.services.CustomerService;
import by.itstep.crm.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registration")
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
    public String registration(UserDto dto) {
        if (userService.loadUserByUsername(dto.getUsername()) != null) {
            return "registration";
        }
        customerService.create(dto);
        return "login";
    }
}

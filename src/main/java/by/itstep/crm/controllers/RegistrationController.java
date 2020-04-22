package by.itstep.crm.controllers;

import by.itstep.crm.entities.Customer;
import by.itstep.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping//todo USERNAME AND PASSWORD CHECK!!!!
    public String registration(
            Customer customer,//TODO Change to customerDto???
            Model model) {
        Customer customerFromDatabase = (Customer) customerService.loadUserByUsername(customer.getUsername());
        if (customerFromDatabase != null) {
            model.addAttribute("message", "Пользователь с таким именем уже существует!");
            return "registration";
        }
        customer.setActive(true);
        customer.setPhone("35715656");//delete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        customerService.save(customer);
        model.addAttribute("message", "Пользователь зарегистрирован, можете выполнить вход");
        return "login";
    }
}

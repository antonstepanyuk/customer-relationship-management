package by.itstep.crm.controllers;

import by.itstep.crm.models.Customer;
import by.itstep.crm.repositories.CustomerRepository;
import by.itstep.crm.services.AdministratorService;
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
//    @Autowired
//    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String registrationForm() {
        return "registration";
    }

    @PostMapping//("/customer")todo ЧТО С СООБЩЕНИЯМИ НА СТРАНИЦЕ?????????
    public String customerRegistration(
            Customer customer,
            Model model) {
        Customer customerFromDatabase = customerRepository.findByUsername(customer.getUsername());
        if (customerFromDatabase != null) {
            model.addAttribute("message", "Пользователь с таким именем уже существует!");
            return "registration";
        }
        customer.setActive(true);
        customerRepository.save(customer);
        model.addAttribute("message", "Пользователь зарегистрирован, можете выполнить вход");
        return "login";
    }
}

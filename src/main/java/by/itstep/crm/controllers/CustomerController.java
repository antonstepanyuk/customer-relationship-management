package by.itstep.crm.controllers;

import by.itstep.crm.entities.Customer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
@PreAuthorize("hasAuthority('CUSTOMER')")
public class CustomerController {

    @GetMapping
    public String customerMain(
            @AuthenticationPrincipal Customer customer,
            Model model) {
        model.addAttribute("username", customer.getUsername());
        return "customer";
    }
}
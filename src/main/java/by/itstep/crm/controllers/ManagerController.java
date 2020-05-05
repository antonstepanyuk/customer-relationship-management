package by.itstep.crm.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
@PreAuthorize("hasAuthority('MANAGER')")
public class ManagerController {


}


package by.itstep.crm.controllers;

import by.itstep.crm.dto.ProductTypeDto;
import by.itstep.crm.entities.ProductType;
import by.itstep.crm.services.ProductTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product_type")
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public String productType(Model model) {
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "productType";
    }


    @PostMapping("create")
    public String create(                         @RequestParam String typeName,
                         @RequestParam String comment,
                         Model model) {
        ProductType typeFromDatabase = productTypeService.loadProductTypeByTypeName(typeName);
        if (typeFromDatabase != null) {
            model.addAttribute("types", productTypeService.loadAllProductTypes());
            return "productType";
        }
        productTypeService.create(typeName,comment);
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "productType";
    }


    @PostMapping("edit")//{typeId}
    public String editForm(@RequestParam Long typeId,
                           Model model) {
        model.addAttribute("productType", productTypeService.loadProductTypeById(typeId));
        return "productTypeEdit";

    }

    @PostMapping("save")
    public String update(@RequestParam Long typeId,
                         @RequestParam String typeName,
                         @RequestParam String comment,
                         Model model) {
        ProductType typeFromDatabase = productTypeService.loadProductTypeByTypeName(typeName);
        if (typeFromDatabase != null) {
            model.addAttribute("types", productTypeService.loadAllProductTypes());
            model.addAttribute("productType", productTypeService.loadProductTypeById(typeId));
            return "productTypeEdit";
        }
        productTypeService.save(typeId,typeName,comment);
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "productType";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("typeId") Long id,
            Model model) {
        productTypeService.delete(id);
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "productType";
    }
}

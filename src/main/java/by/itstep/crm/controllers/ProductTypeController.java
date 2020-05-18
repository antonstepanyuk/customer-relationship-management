package by.itstep.crm.controllers;

import by.itstep.crm.dto.ProductTypeDto;
import by.itstep.crm.services.ProductTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("product/type")
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public String productTypeForm(Model model) {
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "productType";
    }

    @PostMapping("create")
    public String create(ProductTypeDto dto, Model model) {
        if (productTypeService.loadProductTypeByTypeName(dto.getTypeName()) != null) {
//            model.addAttribute("types", productTypeService.loadAllProductTypes());
            return "redirect:/product/type";
        }
        productTypeService.create(dto);
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "redirect:/product/type";
    }


    @PostMapping("edit")//todo{typeId}
    public String editForm(@RequestParam Long typeId, Model model) {
        model.addAttribute("productType", productTypeService.loadProductTypeById(typeId));
        return "productTypeEdit";
    }

    @PostMapping("save")
    public String update(ProductTypeDto dto,
                         Model model) {
        if (productTypeService.loadProductTypeByTypeName(dto.getTypeName()) != null) {
            model.addAttribute("types", productTypeService.loadAllProductTypes());
            return "redirect:/product/type/edit";
        }
        productTypeService.save(dto);
        return "redirect:/product/type";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("typeId") Long id,
                         Model model) {
        productTypeService.delete(id);
        model.addAttribute("types", productTypeService.loadAllProductTypes());
        return "productType";
    }
}

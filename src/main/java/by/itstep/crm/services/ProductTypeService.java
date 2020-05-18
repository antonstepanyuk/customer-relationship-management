package by.itstep.crm.services;

import by.itstep.crm.dto.ProductTypeDto;
import by.itstep.crm.entities.ProductType;
import by.itstep.crm.repositories.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public ProductTypeService(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    public ProductType loadProductTypeByTypeName(String name) {
        return productTypeRepository.findByTypeName(name);
    }

    public ProductType loadProductTypeById(Long id) {
        return productTypeRepository.findProductTypeById(id);
    }

    public List<ProductType> loadAllProductTypes() {
        return (List<ProductType>) productTypeRepository.findAll();
    }

    public void create(ProductTypeDto dto) {
        ProductType productType = new ProductType();
        productType.setTypeName(dto.getTypeName());
        productType.setComment(dto.getComment());
        productTypeRepository.save(productType);
    }

    public void delete(Long id) {
        productTypeRepository.deleteById(id);
    }

    public void save(ProductTypeDto dto) {
        ProductType typeFromDatabase = productTypeRepository.findProductTypeById(dto.getId());
        if (!dto.getTypeName().isEmpty()) {
            typeFromDatabase.setTypeName(dto.getTypeName());
        }
        if (!dto.getComment().isEmpty()) {
            typeFromDatabase.setComment(dto.getComment());
        }
        productTypeRepository.save(typeFromDatabase);
    }

}

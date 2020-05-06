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

    public void create(String typeName, String comment) {

        ProductType productType = new ProductType();
        productType.setTypeName(typeName);
        productType.setComment(comment);
        productTypeRepository.save(productType);
    }

    public void delete(Long id) {
        productTypeRepository.deleteById(id);
    }

    public void save(Long typeId, String typeName, String comment) {
        ProductType typeFromDatabase = productTypeRepository.findProductTypeById(typeId);
        if (!typeName.isEmpty()) {
            typeFromDatabase.setTypeName(typeName);
        }
        if (!comment.isEmpty()) {
            typeFromDatabase.setComment(comment);
        }
        productTypeRepository.save(typeFromDatabase);
    }


}

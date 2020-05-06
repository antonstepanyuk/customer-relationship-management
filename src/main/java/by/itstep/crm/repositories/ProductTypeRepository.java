package by.itstep.crm.repositories;

import by.itstep.crm.entities.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {
    ProductType findByTypeName(String typeName);
    ProductType findProductTypeById(Long id);
}

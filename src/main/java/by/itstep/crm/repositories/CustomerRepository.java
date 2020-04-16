package by.itstep.crm.repositories;

import by.itstep.crm.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
Customer findByUsername(String username);
}

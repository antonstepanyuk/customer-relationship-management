package by.itstep.crm.repositories;

import by.itstep.crm.models.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator,Long> {
    Administrator findByUsername(String username);
}
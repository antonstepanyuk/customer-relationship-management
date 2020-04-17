package by.itstep.crm.repositories;

import by.itstep.crm.models.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
    Manager findByUsername(String username);
}

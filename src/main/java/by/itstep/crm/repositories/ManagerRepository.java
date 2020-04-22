package by.itstep.crm.repositories;

import by.itstep.crm.entities.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
    Manager findByUsername(String username);
}

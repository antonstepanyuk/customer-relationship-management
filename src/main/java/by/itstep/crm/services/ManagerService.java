package by.itstep.crm.services;

import by.itstep.crm.models.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerService extends CrudRepository<Manager, Long> {
    Manager findByUsername(String username);
}

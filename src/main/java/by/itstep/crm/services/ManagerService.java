package by.itstep.crm.services;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Manager;
import by.itstep.crm.repositories.ManagerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements UserDetailsService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return managerRepository.findByUsername(username);
    }

    public void create(UserDto dto) {
        //todo try/catch
        Manager manager = new Manager();
        manager.setUsername(dto.getUsername());
        manager.setPassword(dto.getPassword());
        manager.setFirstName(dto.getFirstName());
        manager.setLastName(dto.getLastName());
        manager.setActive(true);
        managerRepository.save(manager);
    }

//    public void save(Manager manager) {
//        managerRepository.save(manager);
//    }


}

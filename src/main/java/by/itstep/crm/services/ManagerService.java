package by.itstep.crm.services;

import by.itstep.crm.models.Manager;
import by.itstep.crm.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements UserDetailsService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return managerRepository.findByUsername(username);
    }

    public void save(Manager manager) {
        managerRepository.save(manager);
    }

}

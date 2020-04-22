package by.itstep.crm.services;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Administrator;
import by.itstep.crm.repositories.AdministratorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService implements UserDetailsService {
    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return administratorRepository.findByUsername(username);
    }

    public void createAdministrator(UserDto userDto) {//todo try/catch
        Administrator administrator = new Administrator();
        administrator.setUsername(userDto.getUsername());
        administrator.setPassword(userDto.getPassword());
        administrator.setFirstName(userDto.getFirstName());
        administrator.setLastName(userDto.getLastName());
        administratorRepository.save(administrator);
    }

//    public void save(Administrator administrator) {
//        administratorRepository.save(administrator);
//    }


}

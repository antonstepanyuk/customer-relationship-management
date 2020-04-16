package by.itstep.crm.services;

import by.itstep.crm.models.Administrator;
import by.itstep.crm.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService{
//public class AdministratorService implements UserDetailsService {
    @Autowired
    private AdministratorRepository administratorRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Administrator administrator=administratorRepository.findByUsername(username);
//        return  administrator;
//        AdministratorDto administratorDto=administratorRepository.findByUsername(username);
//        return administratorDto ;
//    }
}

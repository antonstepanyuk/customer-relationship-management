package by.itstep.crm.services;

import by.itstep.crm.models.Customer;
import by.itstep.crm.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByUsername(username);
    }

    public void save(Customer customer) {//TODO check
        customerRepository.save(customer);
    }

}

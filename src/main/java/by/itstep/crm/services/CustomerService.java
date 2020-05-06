package by.itstep.crm.services;

import by.itstep.crm.dto.UserDto;
import by.itstep.crm.entities.Customer;
import by.itstep.crm.repositories.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByUsername(username);
    }

    public void createCustomer(UserDto userDto) {
        //todo try/catch
        Customer customer = new Customer();
        customer.setUsername(userDto.getUsername());
        customer.setPassword(userDto.getPassword());
        customer.setFirstName(userDto.getFirstName());
        customer.setLastName(userDto.getLastName());
        customerRepository.save(customer);
    }

//    public void save(Customer customer) {//TODO check???
//        customerRepository.save(customer);
//    }


}

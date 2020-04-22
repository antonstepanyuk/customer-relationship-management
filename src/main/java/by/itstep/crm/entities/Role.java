package by.itstep.crm.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMINISTRATOR,
    MANAGER,
    CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}

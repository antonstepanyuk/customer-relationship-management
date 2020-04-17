package by.itstep.crm.models;

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

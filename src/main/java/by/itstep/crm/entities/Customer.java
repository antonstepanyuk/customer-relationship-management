package by.itstep.crm.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.Objects;

@Entity
@Table(name = "customers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User  {
    private String phone;

    @ManyToOne (optional=true, cascade= CascadeType.ALL)
    @JoinColumn (name="manager_id")
   private Manager manager;

    public Customer() {
        this.setRole(Collections.singleton(Role.CUSTOMER));
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(phone, customer.phone) &&
                Objects.equals(manager, customer.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phone, manager);
    }
}

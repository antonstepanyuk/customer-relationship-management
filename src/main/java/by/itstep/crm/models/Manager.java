package by.itstep.crm.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "managers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Manager extends User {
    private String phone;
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Customer> customerList;

    //    @OneToMany(mappedBy = "managerAuthor",fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Reminder> reminders;

    public Manager() {
        this.setRole(Collections.singleton(Role.MANAGER));
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }
}

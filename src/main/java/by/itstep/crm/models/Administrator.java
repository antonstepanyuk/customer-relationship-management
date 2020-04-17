package by.itstep.crm.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "administrators")
@PrimaryKeyJoinColumn(name = "user_id")
public class Administrator extends User {
    //    @OneToMany(mappedBy = "adminstratorAuthor",fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Reminder> reminders;

    public Administrator() {
        this.setRole(Collections.singleton(Role.ADMINISTRATOR));
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }
}

package by.itstep.crm.entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

import static by.itstep.crm.entities.Role.ADMINISTRATOR;

@Entity
@Table(name = "administrators")
@PrimaryKeyJoinColumn(name = "user_id")
public class Administrator extends User {
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Reminder> reminders;

    public Administrator() {
        this.setRole(Collections.singleton(ADMINISTRATOR));
    }//todo static import????

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }
}

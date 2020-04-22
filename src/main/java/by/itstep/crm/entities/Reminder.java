package by.itstep.crm.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="reminders")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Calendar reminderDateTime;
    private String information;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private User author;

//    @ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="user_id")
//    private Administrator adminstratorAuthor;
//
//    @ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="user_id")
//    private Manager managerAuthor;


    public Reminder() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(Calendar reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    //    public Administrator getAdminstratorAuthor() {
//        return adminstratorAuthor;
//    }
//
//    public void setAdminstratorAuthor(Administrator adminstratorAuthor) {
//        this.adminstratorAuthor = adminstratorAuthor;
//    }
//
//    public Manager getManagerAuthor() {
//        return managerAuthor;
//    }
//
//    public void setManagerAuthor(Manager managerAuthor) {
//        this.managerAuthor = managerAuthor;
//    }
}

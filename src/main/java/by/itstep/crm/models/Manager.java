package by.itstep.crm.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name="managers")
public class Manager extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> role;
    private String phone;

    public Manager() {
//        this.setRole(Collections.singleton(Role.MANAGER));
    }
}

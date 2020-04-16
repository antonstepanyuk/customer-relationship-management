package by.itstep.crm.models;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "administrators")
public class Administrator extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
////    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
////    @Enumerated(EnumType.STRING)
//    private Set<Role> role;

    public Administrator() {
//        this.setRole(Collections.singleton(Role.ADMINISTRATOR));
    }
}

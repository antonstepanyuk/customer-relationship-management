package by.itstep.crm.models;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  final String role=Role.CUSTOMER.toString();
//        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//        @ManyToOne
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> role;
    private String phone;

    public Customer() {
//        this.setRole(Collections.singleton(Role.CUSTOMER));
//        this.role= Collections.singleton(Role.CUSTOMER);
    }
}

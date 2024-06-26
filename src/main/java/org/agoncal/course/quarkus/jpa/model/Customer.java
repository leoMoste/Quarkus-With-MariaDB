package org.agoncal.course.quarkus.jpa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer extends PanacheEntity{
    public String firstName;
    public String lastName;
    public String email;

    @OneToMany(mappedBy = "customer")
    public List<CustomerOrder> orders;
}

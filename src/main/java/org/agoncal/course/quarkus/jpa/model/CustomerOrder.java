package org.agoncal.course.quarkus.jpa.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class CustomerOrder extends PanacheEntity {
    @ManyToOne
    public Customer customer;

    @OneToMany(mappedBy = "order")
    public List<OrderItem> orderItems;

}

package org.agoncal.course.quarkus.jpa.model;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem extends PanacheEntity{
    @ManyToOne
    public CustomerOrder order;

    @ManyToOne
    public Item item;

    public int quantity;
}

package org.agoncal.course.quarkus.jpa.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Item extends PanacheEntity {

    public String name;
    public double price;
}

package org.agoncal.course.quarkus.jpa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.course.quarkus.jpa.model.CustomerOrder;

@ApplicationScoped
public class CustomerOrderRepository implements PanacheRepository<CustomerOrder> {
    public CustomerOrder addOrder(CustomerOrder order) {
        if (order.id == null) {
            persist(order);
        } else {
            CustomerOrder existingOrder = findById(order.id);
            if (existingOrder != null) {
                throw new IllegalArgumentException("An order with the same ID already exists.");
            } else {
                persist(order);
            }
        }
        return order;
    }
}

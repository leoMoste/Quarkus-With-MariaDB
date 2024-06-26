package org.agoncal.course.quarkus.jpa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.course.quarkus.jpa.model.OrderItem;

@ApplicationScoped
public class OrderItemRepository implements PanacheRepository<OrderItem> {
    public OrderItem addOrderItem(OrderItem orderItem) {
        if (orderItem.id == null) {
            persist(orderItem);
        } else {
            OrderItem existingOrderItem = findById(orderItem.id);
            if (existingOrderItem != null) {
                throw new IllegalArgumentException("An order item with the same ID already exists.");
            } else {
                persist(orderItem);
            }
        }
        return orderItem;
    }
}
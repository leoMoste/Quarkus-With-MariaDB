package org.agoncal.course.quarkus.jpa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.course.quarkus.jpa.model.Item;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {
    public Item addItem(Item item) {
        if (item.id == null) {
            persist(item);
        } else {
            Item existingItem = findById(item.id);
            if (existingItem != null) {
                throw new IllegalArgumentException("An item with the same ID already exists.");
            } else {
                persist(item);
            }
        }
        return item;
    }}
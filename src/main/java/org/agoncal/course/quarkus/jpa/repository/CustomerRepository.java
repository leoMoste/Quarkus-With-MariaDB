package org.agoncal.course.quarkus.jpa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.agoncal.course.quarkus.jpa.model.Customer;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public Customer addCustomer(Customer customer) {
        if (customer.id == null) {
            persist(customer);
        } else {
            Customer existingCustomer = findById(customer.id);
            if (existingCustomer != null) {
                throw new IllegalArgumentException("A customer with the same ID already exists.");
            } else {
                persist(customer);
            }
        }
        return customer;
    }

}
package org.agoncal.course.quarkus.jpa;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.agoncal.course.quarkus.jpa.model.Customer;
import org.agoncal.course.quarkus.jpa.repository.CustomerRepository;
import java.util.List;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @GET
    public List<Customer> getAllCustomers(){
        return customerRepository.listAll();
    }

    @POST
    @Transactional
    public Response addCustomer(Customer customer) {
        try {
            Customer createdCustomer = customerRepository.addCustomer(customer);
            return Response.status(Response.Status.CREATED).entity(createdCustomer).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

}

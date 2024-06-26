package org.agoncal.course.quarkus.jpa;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.agoncal.course.quarkus.jpa.model.CustomerOrder;
import org.agoncal.course.quarkus.jpa.repository.CustomerOrderRepository;

import java.util.List;


@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerOrderResource {
    @Inject
    CustomerOrderRepository orderRepository;

    @GET
    public List<CustomerOrder> getAllItems(){
        return orderRepository.listAll();
    }

    @POST
    @Transactional
    public Response addOrder(CustomerOrder order) {
        try {
            CustomerOrder createdItem = orderRepository.addOrder(order);
            return Response.status(Response.Status.CREATED).entity(createdItem).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }


}

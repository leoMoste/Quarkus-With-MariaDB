package org.agoncal.course.quarkus.jpa;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.agoncal.course.quarkus.jpa.model.Customer;
import org.agoncal.course.quarkus.jpa.model.Item;
import org.agoncal.course.quarkus.jpa.repository.ItemRepository;

import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

    @Inject
    ItemRepository itemRepository;

    @GET
    public List<Item> getAllItems(){
        return itemRepository.listAll();
    }

    @POST
    @Transactional
    public Response addItem(Item item) {
        try {
            Item createdItem = itemRepository.addItem(item);
            return Response.status(Response.Status.CREATED).entity(createdItem).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }


}

package com.wescale;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/messages")
public class MessagesResource {

    @GET
    @Path("/{id}")
    public Response getMessageById(@PathParam("id") Long id) {
        GreetingEntity entity = GreetingEntity.findById(id);
        return Response.ok(entity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GreetingEntity> getMessages() {
        return GreetingEntity.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(GreetingEntity message) {
        GreetingEntity.persist(message);
        return Response.ok(message).build();
    }
}
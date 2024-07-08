package org.example.jaxrs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {
    @GET
    @Path ("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.status(Response.Status.OK)
                .entity(new Message("Hello, World!"))
                .build();
    }

    @GET
    @Path("/2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bye() {
        return Response.status(Response.Status.OK)
                .entity(new Message("Bye, World!"))
                .build();
    }
}
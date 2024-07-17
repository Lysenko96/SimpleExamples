package org.example.jaxrs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ejb.LocalBean;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/main")
//@LocalBean
public class HelloResource {
    @GET
    @Path ("/1")
    // http://localhost:8080/api/main/1?id=1
    @Produces(MediaType.APPLICATION_JSON)
    public Response one(@QueryParam("id") String id) {
        return Response.status(Response.Status.OK)
                .entity(new Message("one: " + id))
                .build();
    }

    @GET
    @Path("/2/{id}")
    // http://localhost:8080/api/main/2/1
    @Produces(MediaType.APPLICATION_JSON)
    public Response two(@PathParam("id") String id) {
        return Response.status(Response.Status.OK)
                .entity(new Message("two: " + id))
                .build();
    }

    @GET
    @Path("/3")
    // http://localhost:8080/api/main/3;id=1
    @Produces(MediaType.APPLICATION_JSON)
    public Response three(@MatrixParam("id") String id) {
        return Response.status(Response.Status.OK)
                .entity(new Message("three: " + id))
                .build();
    }

    @POST
    @Path("/4")
    // http://localhost:8080/api/main/4
    @Consumes(MediaType.TEXT_PLAIN)
    public String four(String msg) {
        return msg;
    }

    @POST
    @Path("/5")
    // http://localhost:8080/api/main/5
    @Consumes(MediaType.APPLICATION_JSON)
    public String five(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(json, Message.class);
        System.out.println(message);
        return "Done";
    }
}
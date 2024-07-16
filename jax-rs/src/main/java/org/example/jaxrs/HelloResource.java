package org.example.jaxrs;

import jakarta.activation.MimeType;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jersey.repackaged.org.objectweb.asm.Type;
import org.glassfish.jersey.message.internal.FormProvider;
import org.glassfish.jersey.message.internal.ReaderProvider;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Path("/main")
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
}
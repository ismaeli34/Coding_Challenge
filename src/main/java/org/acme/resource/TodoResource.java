package org.acme.resource;

import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.acme.client.TodoClient;
import org.acme.entity.Todo;

import java.util.List;

@Path("/")
public class TodoResource {

    @Inject
    TodoClient typeSafeClient;

    @GET
    @Path("/typesafe")
//    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public List<Todo> getAllTodosTypeSafeClient() {
        return null;
    }


}

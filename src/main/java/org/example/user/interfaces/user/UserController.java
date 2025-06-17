package org.example.user.interfaces.user;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.user.application.user.UserService;
import org.example.user.domain.dto.request.user.CreateUserDTO;

import java.util.UUID;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService userService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") UUID id) {
        return this.userService.findById(id)
                .map(Response::ok)
                .orElse(Response.status(Response.Status.NOT_FOUND))
                .build();
    }

    @POST
    public Response saveUser(CreateUserDTO newUser){
        this.userService.saveUser(newUser);
        return Response.status(Response.Status.CREATED).build();
    }

}

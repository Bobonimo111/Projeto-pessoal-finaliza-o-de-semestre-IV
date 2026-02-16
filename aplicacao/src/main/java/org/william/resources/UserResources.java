package org.william.resources;


import jakarta.ws.rs.*;
import org.william.dto.users.PostUserDTO;
import org.william.services.UserServices;

import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResources {
    private final UserServices userServices;
    
    @Inject
    UserResources(UserServices userServices){
        this.userServices = userServices;
    }
    
    @GET
    public Response getUsers() {
        return Response.ok(this.userServices.getUsers()).build();
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id){
        return Response.status(200).entity(this.userServices.getUserById(id)).build();
    }

    @POST
    public Response CreateUser(PostUserDTO postUserDTO) {
        this.userServices.createUser(postUserDTO);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response UpdateFullUser(PostUserDTO postUserDTO, @PathParam("id") int id) {
        this.userServices.updateFullUser(postUserDTO,id);
        return Response.status(200).build();
    }
}

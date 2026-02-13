package org.william.resources;


import org.william.dto.PostUserDTO;
import org.william.services.UserServices;

import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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

    @POST
    public Response CreateUser( PostUserDTO postUserDTO) {
        this.userServices.createUser(postUserDTO);
        return Response.ok().build();

    }
}

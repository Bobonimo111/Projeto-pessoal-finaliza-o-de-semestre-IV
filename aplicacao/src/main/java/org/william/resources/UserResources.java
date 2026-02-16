package org.william.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.UriInfo;
import org.william.dto.users.GetUserDTO;
import org.william.dto.users.PostUserDTO;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.william.services.UserServices;
import java.net.URI;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResources {
    private final UserServices userServices;
    private final UriInfo uriInfo;

    @Inject
    UserResources(UserServices userServices, UriInfo uriInfo){
        this.userServices = userServices;
        this.uriInfo = uriInfo;
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
        GetUserDTO newUser = this.userServices.createUser(postUserDTO);
        URI newResourceLocation = uriInfo.getBaseUri().resolve("/users/"+newUser.getId());
        System.out.println(newResourceLocation);
        return Response.created(newResourceLocation).build();
    }

    @PUT
    @Path("/{id}")
    public Response UpdateFullUser(PostUserDTO postUserDTO, @PathParam("id") int id) {
        this.userServices.updateFullUser(postUserDTO,id);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response DeleteUser(@PathParam("id") int id) {
        this.userServices.deleteUserById(id);
        return Response.status(204).build();
    }
}

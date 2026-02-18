package org.william.resources;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.william.dto.items.GetitemDTO;
import org.william.dto.items.PostItemDTO;
import org.william.services.ItemService;

import java.net.URI;


@Path("users/{userid}/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemUsersResources {
    private final ItemService itemService;
    private final UriInfo  uriInfo;

    @Inject
    public ItemUsersResources(ItemService itemService, UriInfo uriInfo) {
        this.itemService = itemService;
        this.uriInfo = uriInfo;
    }

    @GET
    public Response getitems(@PathParam("userid") Integer userId) {
        return Response.ok().entity(this.itemService.getitems(userId)).build();
    }


    @POST
    public Response createNewItem(PostItemDTO itemDto,
                                  @PathParam("userid") Integer userid){
        GetitemDTO getitemDTO=  this.itemService.createNewItem(itemDto,userid);
        URI location = this.uriInfo.getBaseUri().resolve("/users/"+getitemDTO.userId()+"/items/");
        return Response.status(201).location(location).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteitems(@PathParam("userid") Integer userid,
                                @PathParam("id") Integer id
                                ){
        try {
            this.itemService.deleteItem(id);
            return Response.status(204).build();
        }catch (Exception ex){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateFullItem(@PathParam("userid") Integer userid,
                                   @PathParam("id") Integer id,
                                   PostItemDTO itemDTO
    ){
        this.itemService.UpdateFullItem(itemDTO,id);
        return Response.ok().build();
    }

}

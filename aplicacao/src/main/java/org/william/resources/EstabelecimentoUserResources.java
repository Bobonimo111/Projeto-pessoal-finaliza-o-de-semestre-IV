package org.william.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.william.dto.estabelecimento.GetEstabelecimento;
import org.william.dto.estabelecimento.PostEstabeleciemento;
import org.william.services.EstabelecimentoService;

import java.net.URI;

@Path("users/{userid}/estabelecimentos/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstabelecimentoUserResources {
    private final EstabelecimentoService estabelecimentoService;
    private final UriInfo uriInfo;

    @Inject
    EstabelecimentoUserResources(EstabelecimentoService es, UriInfo uriInfo){
        this.estabelecimentoService = es;
        this.uriInfo = uriInfo;
    }

    @GET
    public Response getAllEstabelecimentos(@PathParam("userid") Integer userId ){
        return Response.status(200).entity(this.estabelecimentoService.getAllWithUser(userId)).build();
    }

    @POST
    public Response createNewEstabelecimento(@PathParam("userid") Integer userId,
                                             PostEstabeleciemento estabelecimento){

        GetEstabelecimento getEsta = this.estabelecimentoService.createNewEstabelecimentoWithUser(userId,estabelecimento);
        URI location = uriInfo.getBaseUri().resolve("/users/"+userId+"/estabelecimentos/");

        return Response.status(201).location(location).build();
    }

    @DELETE
    @Path("/{estaid}")
    public Response deleteEstabelecimento(@PathParam("userid")Integer userId,
    @PathParam("estaid") Integer estaId){
        this.estabelecimentoService.deleteEstabelecimentoWithUser(userId,estaId);
        return Response.status(204).build();
    }

    @PUT
    @Path("/{estaid}")
    public Response updateFullEstabelecimento(
            @PathParam("userid")Integer userId,
            @PathParam("estaid") Integer estaId,
            PostEstabeleciemento estabelecimento
    ){
        this.estabelecimentoService.updateFullWithUser(userId,estaId,estabelecimento);
        return Response.status(204).build();
    }


}

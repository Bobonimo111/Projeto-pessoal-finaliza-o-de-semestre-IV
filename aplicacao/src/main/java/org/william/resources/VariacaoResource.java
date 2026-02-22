package org.william.resources;


import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheResult;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.william.dto.varicaoItem.GetVaricao;
import org.william.dto.varicaoItem.PostVariacao;
import org.william.services.VariacaoService;

import java.net.URI;

@Path("users/{userid}/variacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VariacaoResource {

    private final VariacaoService variacaoService;
    private final UriInfo uriInfo;

    @Inject
    public VariacaoResource(VariacaoService variacaoService, UriInfo uriInfo) {
        this.variacaoService = variacaoService;
        this.uriInfo = uriInfo;
    }

    @GET
    @CacheResult(cacheName = "variacaoCache")
    public Response getAllVariacao(@PathParam("userid")Integer userId){
        return Response.status(200).entity(this.variacaoService.getAll(userId)).build();
    }

    @POST
    @CacheInvalidate(cacheName = "variacaoCache")
    public Response createNewVariacao(@PathParam("userid") Integer userId, PostVariacao postVariacao){
        GetVaricao getVaricao = this.variacaoService.createNew(userId,postVariacao);
        URI UriLocation = this.uriInfo.getBaseUri().resolve("/users/%s/variacoes".formatted(userId));
        return Response.status(201).location(UriLocation).build();
    }

    @DELETE
    @Path("/{variaId}")
    public Response deleteVariacao(@PathParam("userid") Integer userId,@PathParam("variaId") Integer variaId){
        this.variacaoService.delete(userId,variaId);
        return Response.status(204).build();
    }

    @PUT
    @Path("/{variaId}")
    @CacheInvalidate(cacheName = "variacaoCache")
    public Response createNewVariacao(@PathParam("userid") Integer userId,
                                      @PathParam("variaId") Integer variaId,
                                      PostVariacao postVariacao){
        this.variacaoService.updateFull(userId,variaId,postVariacao);
        return Response.status(204).build();
    }

}

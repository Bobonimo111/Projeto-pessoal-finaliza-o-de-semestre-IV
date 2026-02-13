package org.william.controllers;

import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/users")
public class UserResources {
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<String> getUsers() {
        return List.of("Alice", "Bob", "Charlie");
    }
}

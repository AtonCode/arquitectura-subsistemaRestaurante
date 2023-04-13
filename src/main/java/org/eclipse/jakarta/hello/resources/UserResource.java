package org.eclipse.jakarta.hello.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.model.User;

import org.eclipse.jakarta.hello.repository.UserRepository;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserRepository userRepositoy;

    // Create a new user using POST
    @POST
    @Path("create")
    public User createUser(User user) {
        // Create the user
        userRepositoy.create(user);
        return user;
    }

    // Get all users
    @GET
    @Path("all")
    public User[] getAllUsers() {
        // Search for all users and return them
        return userRepositoy.listAll()
                .stream()
                .toArray(User[]::new);

    }

    // Get a user by id
    @GET
    @Path("{id}")
    public User getUserById(@PathParam("id") Long id) {
        // Search for the user and return it
        return userRepositoy.read(id);
    }

    //Get a user by email and password
    @GET
    @Path("login/{email}/{password}")
    public Response getUserByEmailAndPassword(@PathParam("email") String email, @PathParam("password") String password) {
        // Search for the user and return it
        return Response.ok(userRepositoy.readByEmailAndPassword(email, password)).build();
    }

    // Update a user
    @PUT
    @Path("update/{id}")
    public User updateUser(@PathParam("id") Long id, User user) {
        // Update the user
        userRepositoy.update(user);
        return user;
    }


    // Delete a user
    @DELETE
    @Path("delete/{id}")
    public void deleteUser(@PathParam("id") Long id) {
        // Delete the user
        userRepositoy.delete(id);
    }


}

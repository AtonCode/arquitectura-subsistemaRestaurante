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
    public Response getAllUsers() {
        // Search for all users and return them
        return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(userRepositoy.listAll()
                            .stream()
                            .toArray(User[]::new)).build();

    }

    // Get a user by id
    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") Long id) {
        // Search for the user and return it
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(userRepositoy.read(id)).build();
    }

    //Get a user by email and password
    @GET
    @Path("login/{email}/{password}")
    public Response getUserByEmailAndPassword(@PathParam("email") String email, @PathParam("password") String password) {
        // Search for the user and return it

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(userRepositoy.readByEmailAndPassword(email, password)).build();
    }

    // Update a user
    @PUT
    @Path("update/{email}")
    public Response updateUser(@PathParam("email") String email) {
        // Update the user
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(userRepositoy.update(userRepositoy.updateByEmail(email))).build();
    }


    // Delete a user
    @DELETE
    @Path("delete/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        // Delete the user
        userRepositoy.delete(id);

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity("User deleted").build();
    }


}

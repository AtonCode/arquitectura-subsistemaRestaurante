package org.eclipse.jakarta.hello.aplication.restService.birth;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.birth.mapper.Restaurant;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.birth.repository.RestauraurantJpaRepositoryImpl;

@Path("birth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class birthRESTserviceImpl {

    @Inject
    private RestauraurantJpaRepositoryImpl restauraurantJpaRepositoryImpl;

    @OPTIONS
    @Path("{path : .*}")
    public Response options() {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

    // Create a new user using POST
    @POST
    @Path("create")
    public Restaurant createRestaurant(Restaurant restaurant) {
        // Create the user
        restauraurantJpaRepositoryImpl.create(restaurant);
        return restaurant;
    }

    // Create a new user using GET
    @GET
    @Path("all")
    public Response getAllRestaurant() {
        // get all Restaurant
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(restauraurantJpaRepositoryImpl.listAll()).build();

    }
}

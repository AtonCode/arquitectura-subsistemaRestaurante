package org.eclipse.jakarta.hello.aplication.restService.ingredient;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet.mapper.Ingredient;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet.repository.IngredientJpaRepositoryImpl;

@Path("ingredient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IngredientIRESTserviceImpl {

    @Inject
    private IngredientJpaRepositoryImpl ingredientJpaRepository;

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

    @POST
    @Path("create")
    public Response create(Ingredient entity) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(ingredientJpaRepository.create(entity)).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(ingredientJpaRepository.listAll()).build();

    }

    @PUT
    @Path("update")
    public Response update(Ingredient entity) {
        ingredientJpaRepository.update(entity);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(entity).build();
    }
}
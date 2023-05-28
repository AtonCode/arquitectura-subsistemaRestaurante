package org.eclipse.jakarta.hello.aplication.restService.queue;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService.IRESTservice;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.queue.repository.QueueJpaRepositoryImpl;

@Path("queue")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Dependent
public class QueueRESTserviceImpl<Queue> implements IRESTservice<Queue> {
    @Inject
    private QueueJpaRepositoryImpl queueJpaRepositoryImpl;

    @POST
    @Path("create")
    @Override
    public Response create(Queue entity) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(queueJpaRepositoryImpl.create(entity)).build();

    }

    @GET
    @Path("all")
    @Override
    public Response getAll() {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(queueJpaRepositoryImpl.listAll())
                .build();
    }
    @GET
    @Path("{id}")
    @Override
    public Response getObjectById(Long id) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(queueJpaRepositoryImpl.findById(id))
                .build();
    }
    @PUT
    @Path("update")
    @Override
    public Response update(Queue entity) {
        queueJpaRepositoryImpl.update(entity);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(entity)
                .build();
    }
    @DELETE
    @Path("delete/{id}")
    @Override
    public Response delete(Long id) {
        queueJpaRepositoryImpl.delete(queueJpaRepositoryImpl.findById(id));
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }
}

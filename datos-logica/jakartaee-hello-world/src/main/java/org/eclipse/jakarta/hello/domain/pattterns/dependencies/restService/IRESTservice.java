package org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

public interface IRESTservice<T> {

    public Response create(T entity);

    public Response getAll();

    // Get an order by id
    public Response getObjectById(@PathParam("Id") Long id);

    // Update an order
    public Response update(T entity);

    // Delete an order
    public Response delete(@PathParam("Id") Long id);


}

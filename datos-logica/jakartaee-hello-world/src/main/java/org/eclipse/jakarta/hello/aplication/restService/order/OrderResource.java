package org.eclipse.jakarta.hello.aplication.restService.order;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.order.mapper.Order;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.order.repository.OrderRepository;

@Path("order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    private OrderRepository orderRepository;

    // Create a new order using POST
    @POST
    @Path("create")
    public Response createOrder(Order order) {

        // Create the order
        if(orderRepository.create(order) != null){
            System.out.println("Test 1 Order created");
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")

                    .entity(order).build();
        }
        else{
            System.out.println("Test 2 Order not created");
            return Response
                    .status(400)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity("Order not created").build();
        }

    }

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


    // Get all orders
    @GET
    @Path("all")
    public Response getAllOrders() {
        // Search for all orders and return them

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(orderRepository.listAll()
                        .stream()
                        .toArray(Order[]::new)).build();
    }

    // Get an order by id
    @GET
    @Path("id={id}")
    public Response getOrderById(@PathParam("id") Long id) {
        // Search for the order and return it

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(orderRepository.read(id)).build();
    }

    // Update an order
    @PUT
    @Path("update/{id}")
    public Response updateOrder(@PathParam("id") Long id, Order order) {
        // Update the order
        orderRepository.update(order);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(orderRepository.read(id)).build();


    }

    // Delete an order
    @DELETE
    @Path("delete/{id}")
    public Response deleteOrder(@PathParam("id") Long id) {
        // Delete the order
        orderRepository.delete(id);
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }


    //List all orders for a customer
    @GET
    @Path("user/id={id}")
    public Response getOrdersByUserId(@PathParam("id") Long id) {

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(orderRepository.readByUser(id)
                        .stream()
                        .toArray(Order[]::new)).build();


    }

    //List all orders active for a user
    @GET
    @Path("user/id={id}/approved")
    public Response getApprovedOrdersByUserId(@PathParam("id") Long id) {
        // Search for all orders and return them

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(orderRepository.readApprovedByUser(id)
                        .stream()
                        .toArray(Order[]::new)).build();
    }

    //List all orders pay for a user
    @GET
    @Path("user/id={id}/pay")
    public Response getPayOrdersByUserId(@PathParam("id") Long id) {
        // Search for all orders and return them

        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(orderRepository.readPayByUser(id)
                        .stream()
                        .toArray(Order[]::new)).build();

    }

}

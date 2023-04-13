package org.eclipse.jakarta.hello.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;
import org.eclipse.jakarta.hello.model.Order;
import org.eclipse.jakarta.hello.repository.OrderRepository;

@Path("order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    private OrderRepository orderRepository;

    // Create a new order using POST
    @POST
    @Path("create")
    public Order createOrder(Order order) {
        // Create the order
        orderRepository.create(order);
        return order;
    }

    // Get all orders
    @GET
    @Path("all")
    public Order[] getAllOrders() {
        // Search for all orders and return them
        return orderRepository.listAll()
                .stream()
                .toArray(Order[]::new);
    }

    // Get an order by id
    @GET
    @Path("{id}")
    public Order getOrderById(@PathParam("id") Long id) {
        // Search for the order and return it
        return orderRepository.read(id);
    }

    // Update an order
    @PUT
    @Path("update/{id}")
    public Order updateOrder(@PathParam("id") Long id, Order order) {
        // Update the order
        orderRepository.update(order);
        return order;
    }

    // Delete an order
    @DELETE
    @Path("delete/{id}")
    public void deleteOrder(@PathParam("id") Long id) {
        // Delete the order
        orderRepository.delete(id);
    }


    //List all orders for a customer
    @GET
    @Path("user/{id}")
    public Order[] getOrdersByUserId(@PathParam("id") Long id) {
        // Search for all orders and return them
        return orderRepository.readByUser(id)
                .stream()
                .toArray(Order[]::new);
    }

    //List all orders active for a user
    @GET
    @Path("user/{id}/approved")
    public Order[] getApprovedOrdersByUserId(@PathParam("id") Long id) {
        // Search for all orders and return them
        return orderRepository.readApprovedByUser(id)
                .stream()
                .toArray(Order[]::new);
    }

    //List all orders pay for a user
    @GET
    @Path("user/{id}/pay")
    public Order[] getPayOrdersByUserId(@PathParam("id") Long id) {
        // Search for all orders and return them
        return orderRepository.readPayByUser(id)
                .stream()
                .toArray(Order[]::new);
    }



}

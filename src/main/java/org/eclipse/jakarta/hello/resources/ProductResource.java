package org.eclipse.jakarta.hello.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jakarta.hello.model.Product;
import org.eclipse.jakarta.hello.repository.ProductRepositoy;
@Path("product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductRepositoy productRepositoy;

    // Create a new product using POST
    @POST
    @Path("create")
    public Product createProduct(Product product) {
        // Create the product
        productRepositoy.create(product);
        return product;
    }


    // Get all products
    @GET
    @Path("all")
    public Product[] getAllProducts() {
        // Search for all products and return them
        return productRepositoy.listAll()
                .stream()
                .toArray(Product[]::new);

    }

    // Get a product by id
    @GET
    @Path("{id}")
    public Product getProductById(@PathParam("id") Long id) {
        // Search for the product and return it
        return productRepositoy.read(id);
    }

    // Update a product
    @PUT
    @Path("update/{id}")
    public Product updateProduct(@PathParam("id") Long id, Product product) {
        // Update the product
        productRepositoy.update(product);
        return product;
    }

    // Delete a product
    @DELETE
    @Path("delete/{id}")
    public void deleteProduct(@PathParam("id") Long id) {
        // Delete the product
        productRepositoy.delete(id);
    }



}

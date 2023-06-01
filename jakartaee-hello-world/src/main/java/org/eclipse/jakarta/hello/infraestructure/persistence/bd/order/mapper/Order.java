package org.eclipse.jakarta.hello.infraestructure.persistence.bd.order.mapper;

import jakarta.persistence.*;
import org.eclipse.jakarta.hello.domain.entities.OrderImpl;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.product.mapper.Product;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends OrderImpl implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "address")
    private String address;

    @Column(name = "userName")
    private String userName;

    @Column(name = "status")
    private String status;

    @ManyToMany
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Column(name = "quantities")
    private String quantities;

    public Order() {
    }

    public Order(int id, int userId, String address, String userName, String status, List<Product> products, String quantities) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.userName = userName;
        this.status = status;
        this.products = products;
        this.quantities = quantities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }
}
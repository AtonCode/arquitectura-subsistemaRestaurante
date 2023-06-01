package org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet.mapper;

import jakarta.persistence.*;
import org.eclipse.jakarta.hello.domain.entities.IngredientImpl;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.product.mapper.Product;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient extends IngredientImpl implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany
    @JoinTable(
            name = "products_ingerdients",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Ingredient() {
    }

    public Ingredient(Long id, String name, int quantity, List<Product> products) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

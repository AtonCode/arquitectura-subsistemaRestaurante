package org.eclipse.jakarta.hello.infraestructure.persistence.bd.product.mapper;

import jakarta.persistence.*;
import org.eclipse.jakarta.hello.domain.entities.ProductImpl;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "products")
public class Product extends ProductImpl implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private float value;

    @Column(name = "image")
    private String image;

    public Product() {
    }

    public Product(Long id, String name, String description, float value, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
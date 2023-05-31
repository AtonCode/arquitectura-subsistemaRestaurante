package org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ingredient")
public class IngredientImpl extends org.eclipse.jakarta.hello.domain.entities.IngredientImpl implements Serializable {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    public IngredientImpl() {
    }

    public IngredientImpl(Long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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
}

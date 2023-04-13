package org.eclipse.jakarta.hello.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "isPaid")
    private boolean isPaid;

    //isApproved
    @Column(name = "isApproved")
    private boolean isApproved;


    public Order() {
    }

    public Order(Long id, Long userId, Long productId, boolean isPaid, boolean isApproved) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.isPaid = isPaid;
        this.isApproved = isApproved;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}

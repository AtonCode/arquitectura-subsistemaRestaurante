package org.eclipse.jakarta.hello.infraestructure.persistence.bd.queue.mapper;


import jakarta.persistence.*;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.order.mapper.Order;

import java.sql.Date;
import java.util.HashMap;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="created_at")
    private Date created_at;
    @Column(name="order_id")
    private Long order_id;

    @Column(name="status")
    private String status;

    @Column(name="keepalive")
    private String keepalive;

    public Queue() {
    }

    public Queue(Long id, Date created_at, Long order_id, String status, String keepalive) {
        this.id = id;
        this.created_at = created_at;
        this.order_id = order_id;
        this.status = status;
        this.keepalive = keepalive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(String keepalive) {
        this.keepalive = keepalive;
    }
}

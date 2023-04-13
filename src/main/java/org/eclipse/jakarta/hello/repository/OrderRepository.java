package org.eclipse.jakarta.hello.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.model.Order;
import java.util.List;

@Transactional
@Dependent
public class OrderRepository {

    @Inject
    EntityManager em;

    //CRUD
    public void create(Order order) {em.persist(order);}

    public Order read(Long orderNo) {
        return em.find(Order.class, orderNo);
    }

    public void update(Order order) {em.merge(order);}

    public void delete(Long orderNo) {
        Order order = em.find(Order.class, orderNo);
        em.remove(order);
    }

    //List all
    public List<Order> listAll() {
        return em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }






    //Read all orders for a user
    public List<Order> readByUser(Long userId) {
        return em.createQuery("SELECT o FROM Order o WHERE o.userId = :userId", Order.class)
                .setParameter("userId", userId)
                .getResultList();
    }


    public List<Order> readPayByUser(Long id) {
        return em.createQuery("SELECT o FROM Order o WHERE o.userId = :id AND o.isPaid = true", Order.class)
                .setParameter("id", id)
                .getResultList();

    }

    public List<Order> readApprovedByUser(Long id) {
        return em.createQuery("SELECT o FROM Order o WHERE o.userId = :id AND o.isApproved = true", Order.class)
                .setParameter("id", id)
                .getResultList();

    }
}

package org.eclipse.jakarta.hello.infraestructure.persistence.bd.order.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.infraestructure.persistence.bd.order.mapper.Order;
import java.util.List;

@Transactional
@Dependent
public class OrderRepository {

    @Inject
    EntityManager em;

    //CRUD
    public Order create(Order order) {
        em.persist(order);
        return order;
    }

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

}
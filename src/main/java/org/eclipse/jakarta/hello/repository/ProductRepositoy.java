package org.eclipse.jakarta.hello.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.model.Product;

import java.util.List;


@Transactional
@Dependent
public class ProductRepositoy {

    @Inject
    EntityManager em;

    //CRUD
    public void create(Product product) {em.persist(product);}

    public Product read(Long id) {
        return em.find(Product.class, id);
    }

    public void update(Product product) {em.merge(product);}

    public void delete(Long product) {
        em.remove(product);
    }

    //List all products
    public List<Product> listAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}

package org.eclipse.jakarta.hello.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.model.Product;

import java.math.BigInteger;
import java.util.List;


@Transactional
@Dependent
public class ProductRepositoy {

    @Inject
    EntityManager em;


    //CRUD
    public Product create(Product product) {
        em.persist(product);
        return product;
    }

    public Product read(Long id) {
        return em.find(Product.class, id);
    }

    public Product update(Product product) {
        return em.merge(product);
    }

    public Product delete(Long id) {
        Product product = em.find(Product.class, id);
        return em.merge(product);
    }

    //List all products
    public List<Product> listAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}

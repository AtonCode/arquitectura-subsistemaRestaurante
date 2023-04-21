package org.eclipse.jakarta.hello.infraestructure.persistence.bd.product.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService.IJpaRepository;

import java.util.List;

@Transactional
@Dependent
public class ProductJpaRepositoryImpl<Product> extends IJpaRepository<Product> {

    @Inject
    public ProductJpaRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Product> listAll(Product object) {
        return em.createQuery("SELECT o FROM " + object.getClass().getSimpleName() + " o", (Class<Product>) object.getClass()).getResultList();
    }

    @Override
    public Product create(Product object) {
        em.persist(object);
        return object;
    }
    @Override
    public void update(Product object) {
        em.merge(object);
    }

    @Override
    public void delete(Product object) {
        em.remove(object);
    }

    public List<Product> listAll() {
        return (List<Product>) em.createQuery("SELECT p FROM Product p", org.eclipse.jakarta.hello.infraestructure.persistence.bd.product.mapper.Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return (Product) em.find(org.eclipse.jakarta.hello.infraestructure.persistence.bd.product.mapper.Product.class, id);
    }

}
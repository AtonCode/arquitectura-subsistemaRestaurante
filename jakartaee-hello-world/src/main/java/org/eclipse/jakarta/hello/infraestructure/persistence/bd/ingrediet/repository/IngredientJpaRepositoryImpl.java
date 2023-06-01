package org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.domain.entities.IngredientImpl;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService.IJpaRepository;

import java.util.List;


@Transactional
@Dependent
public class IngredientJpaRepositoryImpl<Ingredient> extends IJpaRepository<Ingredient> {

    @Inject
    public IngredientJpaRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<Ingredient> listAll(Ingredient object) {
        return em.createQuery("SELECT o FROM " + object.getClass().getSimpleName() + " o", (Class<Ingredient>) object.getClass()).getResultList();
    }

    @Override
    public Ingredient create(Ingredient object) {
        em.persist(object);
        return object;
    }

    @Override
    public void update(Ingredient object) {
        em.merge(object);
    }

    @Override
    public void delete(Ingredient object) {
        em.remove(object);
    }

    public List<Ingredient> listAll() {
        return (List<Ingredient>) em.createQuery("SELECT i FROM Ingredient i", IngredientImpl.class).getResultList();
    }

    // Get ingredient by product id from the table products_ingerdients
    public List<Ingredient> getIngredientsByProductId(Long id) {
        return (List<Ingredient>) em.createQuery("SELECT i FROM Ingredient i JOIN i.products p WHERE p.id = :id", IngredientImpl.class).setParameter("id", id).getResultList();
    }
}

package org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService.IJpaRepository;

import java.util.List;


@Transactional
@Dependent
public class IngredientJpaRepositoryImpl<IngredientImpl> extends IJpaRepository<IngredientImpl> {

    @Inject
    public IngredientJpaRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public List<IngredientImpl> listAll(IngredientImpl object) {
        return em.createQuery("SELECT o FROM " + object.getClass().getSimpleName() + " o", (Class<IngredientImpl>) object.getClass()).getResultList();
    }

    @Override
    public IngredientImpl create(IngredientImpl object) {
        em.persist(object);
        return object;
    }

    @Override
    public void update(IngredientImpl object) {
        em.merge(object);
    }

    @Override
    public void delete(IngredientImpl object) {
        em.remove(object);
    }

    public List<IngredientImpl> listAll() {
        return (List<IngredientImpl>) em.createQuery("SELECT i FROM IngredientImpl i", org.eclipse.jakarta.hello.infraestructure.persistence.bd.ingrediet.IngredientImpl.class).getResultList();
    }
}

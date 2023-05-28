package org.eclipse.jakarta.hello.infraestructure.persistence.bd.birth.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService.IJpaRepository;

import java.util.List;

@Transactional
@Dependent
public class RestauraurantJpaRepositoryImpl<Restaurant> extends IJpaRepository<Restaurant> {


    @Inject
    public RestauraurantJpaRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Restaurant create(Restaurant object) {
        em.persist(object);
        return object;
    }

    @Override
    public void update(Restaurant object) {
        em.merge(object);
    }

    @Override
    public void delete(Restaurant object) {
        em.remove(object);
    }

    @Override
    public Restaurant findById(Long id) {
        return (Restaurant) em.find(org.eclipse.jakarta.hello.infraestructure.persistence.bd.birth.mapper.Restaurant.class, id);
    }

    public List<Restaurant> listAll() {
        return (List<Restaurant>) em.createQuery("SELECT p FROM Restaurant p", org.eclipse.jakarta.hello.infraestructure.persistence.bd.birth.mapper.Restaurant.class).getResultList();
    }


}

package org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService;

import jakarta.persistence.EntityManager;
import java.util.List;


public abstract class IJpaRepository<T> {

    protected EntityManager em;

    public IJpaRepository(EntityManager em) {
        super();
        this.em = em;
    }
    public T create(T object) {
        em.persist(object);
        return object;
    }
    public T findById(Long id) {
        return em.find((Class<T>) this.getClass(), id);
    }
    public T read(T object) {
        return em.find((Class<T>) object.getClass(), object);
    }
    public void update(T object) {
        em.merge(object);
    }
    public void delete(T object) {

        em.remove(object);
    }
    public List<T> listAll(T object) {
        return em.createQuery("SELECT o FROM " + object.getClass().getSimpleName() + " o", (Class<T>) object.getClass()).getResultList();
    }
}

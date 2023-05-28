package org.eclipse.jakarta.hello.infraestructure.persistence.bd.queue.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.restService.IJpaRepository;

import java.util.List;

@Transactional
@Dependent
public class QueueJpaRepositoryImpl<Queue> extends IJpaRepository<Queue> {

    @Inject
    public QueueJpaRepositoryImpl(EntityManager em) {
        super(em);
    }

    // Create
    @Override
    public Queue create(Queue object) {
        em.persist(object);
        return object;
    }

    @Override
    public Queue read(Queue object) {
        return em.find((Class<Queue>) object.getClass(), object);
    }

    // Read
    @Override
    public Queue findById(Long id) {
        return em.find((Class<Queue>) this.getClass(), id);
    }

    // Update
    @Override
    public void update(Queue object) {
        em.merge(object);
    }

    // Delete
    @Override
    public void delete(Queue object) {
        em.remove(object);
    }

    // List
    public java.util.List<Queue> listAll() {
        return (List<Queue>) em.createQuery("SELECT q FROM Queue q", org.eclipse.jakarta.hello.infraestructure.persistence.bd.queue.mapper.Queue.class).getResultList();
    }
}

package org.eclipse.jakarta.hello.infraestructure.persistence.bd;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.eclipse.jakarta.hello.domain.pattterns.dependencies.persistence.IEntityManagerProducer;

@ApplicationScoped
public class EntityManagerProducer implements IEntityManagerProducer {

    @PersistenceUnit (unitName = "myPersistenceUnit")
    EntityManagerFactory emf;

    @Produces
    @Default
    public EntityManager createEntityManager() {
        return this.emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }

}

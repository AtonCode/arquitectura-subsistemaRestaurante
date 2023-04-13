package org.eclipse.jakarta.hello.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.eclipse.jakarta.hello.model.User;

import java.util.List;

@Transactional
@Dependent
public class UserRepository {

    @Inject
    EntityManager em;

    //CRUD
    public void create(User user) {em.persist(user);}

    public User read(Long id) {
        return em.find(User.class, id);
    }

    //Update a user by email
    public User updateByEmail(String email) {
        return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public User update(User user) {
        em.merge(user);
        return user;
    }


    //Read a user by email and password
    public User readByEmailAndPassword(String email, String password) {
        return em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password", User.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();

    }


    public void delete(Long user) {
        em.remove(user);
    }

    //List all users
    public List<User> listAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}

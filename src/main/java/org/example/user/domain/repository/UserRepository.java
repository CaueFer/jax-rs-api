package org.example.user.domain.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.user.domain.model.User;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public User findById(UUID id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        return em.createQuery("FROM User", User.class)
                .getResultList();
    }

    public void saveUser(User user) {
        em.persist((user));
    }

    public void update(User user) {
        em.merge(user);
    }

    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }
}

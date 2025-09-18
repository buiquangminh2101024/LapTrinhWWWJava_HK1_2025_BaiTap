package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.UserDao;
import iuh.fit.se.models.User;
import iuh.fit.se.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    public UserDaoImpl() {
        this.em = JPAUtil.getEntityManager();
    }

    @Override
    public void save(User user) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(user);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String userId) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
                et.commit();
            }
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(user);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }
}

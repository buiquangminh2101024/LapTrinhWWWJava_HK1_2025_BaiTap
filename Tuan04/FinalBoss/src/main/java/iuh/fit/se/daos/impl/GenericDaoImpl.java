package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.GenericDao;
import iuh.fit.se.utils.JPAUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GenericDaoImpl<T> implements GenericDao<T> {
    protected EntityManager em;
    private Class<T> clazz;

    public GenericDaoImpl(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    public GenericDaoImpl(Class<T> clazz) {
        this.em = JPAUtils.getEntityManager();
        this.clazz = clazz;
    }

    @Override
    public void save(T t) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(t);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    @Override
    public void update(T t) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(t);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    @Override
    public void delete(int id) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            T t = em.find(clazz, id);
            if (t != null) {
                em.remove(t);
            }
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    @Override
    public T findByID(int id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> getAll() {
        return em.createQuery("from " + clazz.getSimpleName(), clazz)
                .getResultList();
    }
}

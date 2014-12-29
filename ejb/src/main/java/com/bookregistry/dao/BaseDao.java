package com.bookregistry.dao;

import com.bookregistry.exceptions.EntityNotFoundException;
import com.bookregistry.exceptions.InvalidInputParametersException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T> {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    private Class<T> entityClass;

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(Integer id) {
        if (id == null) {
            throw new InvalidInputParametersException("Object id is not set.");
        }
        return em.find(entityClass, Long.valueOf(id));
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void save(T obj) {
        em.persist(obj);
    }

    @Override
    public void update(T obj) {
        em.merge(obj);
    }

    @Override
    public void delete(Integer id) {
        T obj = findById(id);
        if (obj != null) {
            em.remove(obj);
        } else {
            throw new EntityNotFoundException("%s with id %d not found.", entityClass.getSimpleName(), id);
        }
    }
}

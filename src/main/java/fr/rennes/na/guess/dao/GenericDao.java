package fr.rennes.na.guess.dao;

import java.util.Collection;

/**
 * Created by herrard on 27/03/15.
 */
public interface GenericDao<T> {

    public void save(T entity);

    public void update(T entity);

    public T findByname(String name);

    public Collection<T> findAll();

    public T findById(long id);

    public void delete(T entity);
}

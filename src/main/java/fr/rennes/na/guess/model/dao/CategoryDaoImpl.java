package fr.rennes.na.guess.model.dao;

import fr.rennes.na.guess.model.entity.Category;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;
import java.util.List;

/**
 * Created by herrard on 27/03/15.
 */
public class CategoryDaoImpl implements CategoryDao {

    private EntityManager em;
    private EntityTransaction tx;

    public CategoryDaoImpl(EntityManager em){
        this.em=em;
        this.tx=em.getTransaction();
    }

    @Override
    public void save(Category entity) {

        tx.begin();
        em.persist(entity);
        tx.commit();

    }

    @Override
    public void update(Category entity) {

        tx.begin();
        em.refresh(entity);
        tx.commit();
    }

    @Override
    public Category findByname(String name) {
        Query q=em.createQuery("SELECT cat FROM  Category AS cat WHERE cname=:name");
        q.setParameter("name",name);
        List<Category> res=q.getResultList();
        if(res.size()==0){
            return null;
        }
        return res.get(0);
    }

    @Override
    public Collection<Category> findAll() {
        Query q=em.createQuery("SELECT cat FROM Category AS cat");

        List<Category> res=q.getResultList();
        if(res.size()==0){
            return null;
        }
        return res;
    }

    @Override
    public Category findById(long id) {
        Query q=em.createQuery("SELECT cat FROM Category AS cat WHERE cat.id=:cid");
        q.setParameter("cid",id);
        List<Category> res=q.getResultList();
        if(res.size()==0){
            return null;
        }
        return res.get(0);
    }

    @Override
    public void delete(Category entity) {

        tx.begin();
        em.remove(entity);
        tx.commit();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityTransaction getTx() {
        return tx;
    }

    public void setTx(EntityTransaction tx) {
        this.tx = tx;
    }
}

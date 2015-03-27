package fr.rennes.na.guess.dao;

import fr.rennes.na.guess.model.entity.Category;
import fr.rennes.na.guess.model.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Created by herrard on 27/03/15.
 */
public class ItemDaoImpl implements ItemDAO {

    private EntityManager em;
    private EntityTransaction tx;

    public ItemDaoImpl(EntityManager em){
        this.em=em;
        this.tx=em.getTransaction();
    }
    @Override
    public void save(Item entity) {

        tx.begin();
        em.persist(entity);
        tx.commit();
    }

    @Override
    public void update(Item entity) {

        tx.begin();
        em.refresh(entity);
        tx.commit();
    }

    @Override
    public Item findByname(String name) {
        Query q=em.createQuery("SELECT Item AS item FROM item WHERE item.content=:name");
        q.setParameter("name",name);
        List<Item> res=q.getResultList();
        return res.get(0);
    }

    @Override
    public Collection<Item> findAll() {
        Query q=em.createQuery("SELECT Item AS item FROM item");
        List<Item> res=q.getResultList();
        return res;
    }

    @Override
    public Item findById(long id) {
        Query q=em.createQuery("SELECT Item AS item FROM item WHERE item.id=:iid");
        q.setParameter("iid",id);
        List<Item> res=q.getResultList();
        return res.get(0);
    }

    @Override
    public void delete(Item entity) {

        tx.begin();
        em.remove(entity);
        tx.commit();
    }

    @Override
    public Collection<Item> findByDiff(int minDiff,int maxDiff){
        Query q=em.createQuery("SELECT Item AS item FROM item " +
                                " WHERE item.difficulty >= :min " +
                                "AND item.difficulty <= :max");
        q.setParameter("min",minDiff);
        q.setParameter("max",maxDiff);
        List<Item> res=q.getResultList();
        return res;
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

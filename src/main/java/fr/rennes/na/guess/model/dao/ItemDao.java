package fr.rennes.na.guess.model.dao;

import fr.rennes.na.guess.model.entity.Item;

import java.util.Collection;

/**
 * Created by herrard on 27/03/15.
 */
public interface ItemDao extends GenericDao<Item> {
    public Collection<Item> findByDiff(int minDiff,int maxDiff);
    public Collection<Item> findByCat(String cat);
    public Collection<Item> findByCatAndDiff(String cat,int minDiff,int maxDiff);
}

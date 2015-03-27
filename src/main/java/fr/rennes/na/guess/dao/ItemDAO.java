package fr.rennes.na.guess.dao;

import fr.rennes.na.guess.model.entity.Item;

import java.util.Collection;

/**
 * Created by herrard on 27/03/15.
 */
public interface ItemDAO extends GenericDao<Item> {
    public Collection<Item> findByDiff(int minDiff,int maxDiff);
}

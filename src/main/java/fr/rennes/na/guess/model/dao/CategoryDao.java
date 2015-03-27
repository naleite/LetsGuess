package fr.rennes.na.guess.model.dao;

import fr.rennes.na.guess.model.entity.Category;
import fr.rennes.na.guess.model.entity.Item;

import java.util.List;

/**
 * Created by herrard on 27/03/15.
 */
public interface CategoryDao extends GenericDao<Category>{
    public List<Item> findAllItemInCat(String cat);
}

package fr.rennes.na.guess.model.service;

import fr.rennes.na.guess.model.dao.CategoryDao;
import fr.rennes.na.guess.model.dao.CategoryDaoImpl;
import fr.rennes.na.guess.model.dao.ItemDao;
import fr.rennes.na.guess.model.dao.ItemDaoImpl;
import fr.rennes.na.guess.model.entity.Category;
import fr.rennes.na.guess.model.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by herrard on 27/03/15.
 */
public class CardServiceImpl implements CardService {

    private CategoryDao catDao;
    private ItemDao itemDao;

    public CardServiceImpl(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("guess");
        EntityManager em=emf.createEntityManager();
        catDao=new CategoryDaoImpl(em);
        itemDao=new ItemDaoImpl(em);
    }

    @Override
    public List<Item> getItems(String catName, int minDiff, int maxDiff) {

        Category cat=catDao.findByname(catName);
        List<Item> allInCat=(List<Item>) cat.getItems();
        List<Item> allDiff=(List<Item>)itemDao.findByDiff(minDiff, maxDiff);
        allInCat.retainAll(allDiff);

        return allInCat;
    }

    @Override
    public void addItemToCat(String word, String catName) {
        Item item=new Item();
        item.setContent(word);
        item.setDifficulty(1);
        Category cat=new Category();
        cat.setCname(catName);
        item.setCateBelong(cat);
        itemDao.save(item);

    }

    @Override
    public void addItemToCat(String word, String catName, int diff) {
        Item item=new Item();
        item.setContent(word);
        item.setDifficulty(diff);
        Category cat=new Category();
        cat.setCname(catName);
        item.setCateBelong(cat);
        itemDao.save(item);
    }
}

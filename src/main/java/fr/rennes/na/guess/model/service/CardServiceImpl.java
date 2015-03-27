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
import java.util.List;

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

        /*Category cat=catDao.findByname(catName);
        if(cat==null ){
            System.out.println("cat");
        }
        List<Item> allInCat=(List<Item>) cat.getItems();
        List<Item> allDiff=(List<Item>)itemDao.findByDiff(minDiff, maxDiff);
        if(allInCat.size()==0 ){
            System.out.println("ALLINCAT");
        }
        if(allDiff.size()==0 ){
            System.out.println("ALLINdiff");
        }
        //allInCat.retainAll(allDiff);

        return allInCat;*/

        List<Item> res=(List<Item>) itemDao.findByCatAndDiff(catName, minDiff, maxDiff);

        return res;
    }

    @Override
    public void addItemToCat(String word, String catName) {
        Item item=new Item();
        item.setContent(word);
        item.setDifficulty(1);
       /* Category cat=new Category();
        cat.setCname(catName);
        item.setCateBelong(cat);
        catDao.save(cat);
        itemDao.save(item);*/
        Category category=catDao.findByname(catName);
        if(category==null){

            Category cat=new Category();
            cat.setCname(catName);
            item.setCateBelong(cat);
            catDao.save(cat);
            itemDao.save(item);
        }
        else{
            item.setCateBelong(category);
            itemDao.save(item);
        }



    }

    @Override
    public void addItemToCat(String word, String catName, int diff) {
        Item item=new Item();
        item.setContent(word);
        item.setDifficulty(diff);

        /*Category cat=new Category();
        cat.setCname(catName);
        item.setCateBelong(cat);
        catDao.save(cat);
        itemDao.save(item);*/
        Category category=catDao.findByname(catName);
        if(category==null){

            Category cat=new Category();
            cat.setCname(catName);
            item.setCateBelong(cat);
            catDao.save(cat);
            itemDao.save(item);
        }
        else{
            item.setCateBelong(category);
            itemDao.save(item);
        }
    }

    @Override
    public List<Item> getAllItemOfCate(String cat) {
         List<Item> res=(List<Item>)itemDao.findByCat(cat);
         return res;
    }
}

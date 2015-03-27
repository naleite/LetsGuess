package fr.rennes.na.guess.model.service;

import fr.rennes.na.guess.model.entity.Item;

import java.util.List;

/**
 * Created by herrard on 27/03/15.
 */
public interface CardService {

    public List<Item> getItems(String catName, int minDiff, int maxDiff);
    public void addItemToCat(String word, String catName);
    public void addItemToCat(String word, String catName,int diff);
    public List<Item> getAllItemOfCate(String cat);
}

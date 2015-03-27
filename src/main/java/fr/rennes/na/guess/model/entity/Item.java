package fr.rennes.na.guess.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by herrard on 27/03/15.
 */

@Entity
public class Item implements Serializable{

    private long id;
    private String content;
    private Category cateBelong;

    //TODO: Verify defalt value
    private int difficulty=1;


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    public Category getCateBelong() {
        return cateBelong;
    }

    public void setCateBelong(Category cateBelong) {
        this.cateBelong = cateBelong;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}

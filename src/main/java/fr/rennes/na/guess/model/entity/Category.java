package fr.rennes.na.guess.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by herrard on 27/03/15.
 */

@Entity
public class Category implements Serializable{

    private long id;
    private String cname;
    private Collection<Item> items;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCname() {

        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @OneToMany(mappedBy = "cateBelong")
    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}

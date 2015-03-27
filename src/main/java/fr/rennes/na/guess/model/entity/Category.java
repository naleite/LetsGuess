package fr.rennes.na.guess.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by herrard on 27/03/15.
 */

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="cname"))
public class Category implements Serializable{

    private long id;
    private String cname;
    private Collection<Item> items=new ArrayList<>();

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique=true, nullable=false)
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

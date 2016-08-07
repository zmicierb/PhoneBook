package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dima on 8/6/16.
 */
@Entity
@Table(name = "FUNCTIONS", schema = "DICT")
public class Function extends AbstractPersistable<String> {

    @Id
    private String id;

    @Column
    private String description;

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

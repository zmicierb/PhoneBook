package by.borisevich.phone.book.domain;

import java.io.Serializable;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
public interface Persistable<ID extends Serializable> extends Serializable{
    ID getId();
}

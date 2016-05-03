package by.borisevich.phone.book.dao.util;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
public class ListOrder {

    private String propertyName;
    private boolean ascending;

    public ListOrder(String propertyName, boolean ascending) {
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    public static ListOrder asc(String propertyName) {
        return new ListOrder(propertyName,true);
    }

    public static ListOrder desc(String propertyName) {
        return new ListOrder(propertyName,false);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public boolean isAscending() {
        return ascending;
    }
}

package by.borisevich.phone.book.tool.generic;

import java.util.List;

/**
 * Created by dima on 10/5/16.
 */
public class Container<T extends Product> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    void copyList(List<? extends Product> src, List<? super Product> dest) {
        //extends - high limit
        //super - low limit

        //extends - in arg
        //super - out arg
        for (Product p : src) {
            dest.add(p);
        }
    }
}

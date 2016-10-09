package by.borisevich.phone.book.tool;

import java.util.Collection;
import java.util.List;

/**
 * Created by dima on 10/5/16.
 */
public class SomeType<E> {

    public <E> void test(Collection<E> collection) {
        for (E e : collection) {
            System.out.println("first method: " + e);
        }
    }

    public void test(List<Integer> list) {
        for (Integer el : list) {
            System.out.println("second method: " + el);
        }
    }
}

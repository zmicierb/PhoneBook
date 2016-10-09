package by.borisevich.phone.book.tool;

/**
 * Created by dima on 10/5/16.
 */
public abstract class Product<T extends Product<T>> implements Comparable<T> {
    private String name;
    private String price;

    public int compareTo(T o) {
        return this.price.compareTo(o.getPrice());
    }

    public abstract int subCompareTo(T product);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

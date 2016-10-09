package by.borisevich.phone.book.tool;

/**
 * Created by dima on 10/5/16.
 */
public class Phone extends Product<Phone> {
    private String model;

    public int subCompareTo(Phone product) {
        return this.model.compareTo(product.getModel());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

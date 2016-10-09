package by.borisevich.phone.book.tool;

/**
 * Created by dima on 10/4/16.
 */
public class Data implements Comparable<Data> {
    private Integer i;
    private String text;

    public Data(int i) {
        this.i = i;
    }

    public int compareTo(Data o) {

        if (this.i % 2 == o.getI() % 2) {
            return this.i.compareTo(o.getI());
        } else if (this.i % 2 < o.getI() % 2) {
            return -1;
        } else {
            return 1;
        }

    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "i=" + i + " text: Comparable interface";
    }
}

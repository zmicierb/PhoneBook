package by.borisevich.phone.book.tool.generic;

/**
 * Created by dima on 10/5/16.
 */
public class Camera extends Product<Camera> {
    private String pixel;

    public int subCompareTo(Camera product) {
        return this.pixel.compareTo(product.getPixel());

    }

    public String getPixel() {
        return pixel;
    }

    public void setPixel(String pixel) {
        this.pixel = pixel;
    }
}

package ObjectSerialization;

import java.io.Serializable;

/**
 * Created by FAB3659 on 2017-05-18.
 */
public class Foo implements Serializable {
    private double width = 10.25;
    private double height = 5.32;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

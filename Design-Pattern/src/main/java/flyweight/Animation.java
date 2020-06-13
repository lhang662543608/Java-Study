package flyweight;

/**
 * 动画
 */
public class Animation extends MultimediaFile {
    @Override
    void display() {
        System.out.println("Animation  " + "size:" + size + "location:" + location);
    }
}

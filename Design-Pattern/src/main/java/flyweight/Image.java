package flyweight;

/**
 * 图片
 */
public class Image extends MultimediaFile {
    @Override
    void display() {
        System.out.println(this + "size：" + size + "location:" + location);
    }
}

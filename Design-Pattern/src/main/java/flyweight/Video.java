package flyweight;

/**
 * 视频
 */
public class Video extends MultimediaFile {
    @Override
    void display() {
        System.out.println("Video  " + "size:" + size + "location:" + location);
    }
}

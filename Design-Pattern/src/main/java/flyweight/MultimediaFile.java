package flyweight;

/**
 * 抽象类----多媒体文件
 */
public abstract class MultimediaFile {
    protected Size size;
    protected Location location;

    abstract void display();

    public void setSize(Size size) {
        this.size = size;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

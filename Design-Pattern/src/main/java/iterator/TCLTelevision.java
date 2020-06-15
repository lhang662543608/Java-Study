package iterator;

/**
 * 具体聚合类
 */
public class TCLTelevision implements Television {
    private Object[] obj = {"频道1", "频道2", "频道3", "频道4",
            "频道5", "频道6", "频道7", "频道8", "频道9"};

    @Override
    public TVIterator createIterator() {
        return new TCLIterator(this.obj);
    }

}

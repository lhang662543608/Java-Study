package iterator;

/**
 * 抽象迭代器
 */
public interface TVIterator {
    public abstract void setChannel(int i);

    public abstract Object currentChannel();

    public abstract void next();

    public abstract void previous();

    public abstract boolean isLast();

    public abstract boolean isFirst();


}

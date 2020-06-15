package iterator;

/**
 * 具体迭代器
 */
public class TCLIterator implements TVIterator {
    private int currentIndex = 0;
    private Object[] obj;

    public TCLIterator(Object[] obj) {
        this.obj = obj;
    }

    @Override
    public void setChannel(int i) {
        if (i < obj.length && i > 0) {
            currentIndex = i;
        } else if (i < 0) {
            currentIndex = 0;
        } else if (i > obj.length) {
            currentIndex = obj.length - 1;
        }
    }

    @Override
    public Object currentChannel() {
        return obj[currentIndex];
    }

    @Override
    public void next() {
        currentIndex++;
    }

    @Override
    public void previous() {
        currentIndex--;
    }

    @Override
    public boolean isLast() {
        return currentChannel() == obj[obj.length - 1];
    }

    @Override
    public boolean isFirst() {
        return currentChannel() == obj[0];
    }

}

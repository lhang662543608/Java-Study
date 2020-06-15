package iterator;

/**
 * 具体聚合类
 */
public class SkyworthTelevision implements Television {
    private Object[] obj = {"频道一", "频道二", "频道三", "频道四",
            "频道五", "频道六", "频道七", "频道八", "频道九"};

    @Override
    public TVIterator createIterator() {
        return new SkyworthIterator();

    }

    /**
     * 具体迭代器
     */
    private class SkyworthIterator implements TVIterator {
        private int currentIndex = 0;

        public SkyworthIterator() {
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
}

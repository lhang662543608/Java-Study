package iterator;

/**
 * 电视机遥控器是一个迭代器的现实应用，通过它可以实现对电视频道集合的遍历操作，
 * 电视机可以看成一个存储频道的聚合对象。
 * 试模拟电视机遥控器的实现，要求绘制相应的类图并使用java语言编程模拟实现。
 */
public class Client {
    public static void main(String[] args) {
//        Television tv = new SkyworthTelevision();
//        Television tv = new TCLTelevision();
        Television tv = (Television) XMLUtils.getBean();
        TVIterator iterator = tv.createIterator();

        System.out.println(iterator.isFirst());//true
        System.out.println(iterator.currentChannel());//频道一
        iterator.next();
        System.out.println(iterator.currentChannel());//频道二
        iterator.next();
        System.out.println(iterator.currentChannel());//频道三
        iterator.setChannel(5);
        System.out.println(iterator.currentChannel());//频道六
        iterator.previous();
        System.out.println(iterator.currentChannel());//频道五
        iterator.setChannel(10000);
        System.out.println(iterator.currentChannel());//频道九
        System.out.println(iterator.isLast());//true


    }
}

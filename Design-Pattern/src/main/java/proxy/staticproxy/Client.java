package proxy.staticproxy;

/**
 * @author lhang
 * @create 2020-06-13 18:51
 */
public class Client {
    public static void main(String[] args) {
        Singer singer = new Singer();
        ProxyInstance proxyInstance = new ProxyInstance(singer);
        proxyInstance.sing();
    }
}

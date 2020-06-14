package proxy.cglibproxy;

/**
 * @author lhang
 * @create 2020-06-14 9:57
 */
public class Client {
    public static void main(String[] args) {
        Singer singer = new Singer();
        Singer proxyInstance = (Singer) new ProxyInstance(singer).getProxyInstance();
        proxyInstance.sing();
    }
}

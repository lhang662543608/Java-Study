package proxy.dynamicproxy;

/**
 * @author lhang
 * @create 2020-06-13 19:01
 */
public class Client {
    public static void main(String[] args) {
        Singer singer = new Singer();
        Sing proxyInstance = (Sing) new ProxyInstance(singer).getProxyInstance();
        proxyInstance.sing();
    }
}

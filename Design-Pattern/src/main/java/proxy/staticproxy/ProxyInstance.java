package proxy.staticproxy;

/**
 * @author lhang
 * @create 2020-06-13 18:49
 */
public class ProxyInstance implements Sing {
    private Sing target;

    public ProxyInstance(Sing target) {
        this.target = target;
    }


    @Override
    public void sing() {
        System.out.println("静态代理~~开始");
        target.sing();
        System.out.println("静态代理~~提交");
    }
}

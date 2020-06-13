package proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lhang
 * @create 2020-06-13 18:53
 */
public class ProxyInstance {
    private Sing target;

    public ProxyInstance(Sing target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        ClassLoader loader = target.getClass().getClassLoader();//当前目标对象使用的类加载器
        Class<?>[] interfaces = target.getClass().getInterfaces();//当前目标对象实现的接口
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理~~开始");
                Object returnValue = method.invoke(target, args);//调用目标对象方法
                System.out.println("动态代理~~提交");
                return returnValue;
            }
        };//事件处理，执行目标对象方法时，触发的操作
        return Proxy.newProxyInstance(loader, interfaces, handler);
    }
}

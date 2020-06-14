package proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lhang
 * @create 2020-06-14 9:28
 */
public class ProxyInstance implements MethodInterceptor {

    private Singer target;

    public ProxyInstance(Singer target) {
        this.target = target;
    }

    //创建一个代理对象：是target对象的代理对象
    public Object getProxyInstance() {
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象即代理对象
        return enhancer.create();

    }

    //重写intercept方法，会调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理~~开始");
        Object returnValue = method.invoke(target, args);
        System.out.println("cglib代理~~提交");
        return returnValue;
    }
}

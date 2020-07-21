package spring4.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author lhang
 * @create 2020-07-21 17:04
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat constructor....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet....");
    }
}

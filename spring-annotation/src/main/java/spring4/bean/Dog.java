package spring4.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lhang
 * @create 2020-07-21 17:16
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("dog constructor.....");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("dog @PostConstruct...");
    }

    //容器移除对象之前调用
    @PreDestroy
    public void destroy() {
        System.out.println("dog @PreDestroy...");
    }
}

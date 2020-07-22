package test.autowired;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring4.bean.Yellow;
import spring4.config.autowired.MainConfig2;

import javax.sql.DataSource;

/**
 * @author lhang
 * @create 2020-07-22 10:52
 */
public class IOCTest_Profile {
    @Test
    public void test01() {
        //1.创建applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3.注册主配置类
        applicationContext.register(MainConfig2.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        applicationContext.close();

    }
}

package spring4.config.component_registration;

import spring4.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring4.config.MyTypeFilter;

/**
 * 配置类===配置文件
 *
 * @author lhang
 * @create 2020-07-21 10:23
 */


@Configuration  //告诉spring这是一个配置类
@ComponentScan(value = "spring4", includeFilters = {
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
},useDefaultFilters = false)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
public class MainConfig {

    @Bean(name = "person") //给容器中注册一个bean；类型为返回值类型，id默认为方法名作为id
    public Person person01() {
        return new Person("Jack", 19);
    }
}

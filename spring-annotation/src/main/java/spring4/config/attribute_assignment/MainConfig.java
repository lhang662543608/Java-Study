package spring4.config.attribute_assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import spring4.bean.Person;

/**
 * @author lhang
 * @create 2020-07-21 18:37
 */
//使用@PropertySource读取外部属性文件中的k/v保存到运行的环境变量中。
@PropertySource(value = {"classpath:person.properties"})
@Configuration
public class MainConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}

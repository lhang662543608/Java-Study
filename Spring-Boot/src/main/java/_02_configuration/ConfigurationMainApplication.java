package _02_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lhang
 * @create 2020-08-13 18:34
 */
//@ImportResource({"classpath:beans.xml"})
@SpringBootApplication
public class ConfigurationMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigurationMainApplication.class, args);
    }
}

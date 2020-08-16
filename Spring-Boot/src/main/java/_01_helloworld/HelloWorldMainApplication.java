package _01_helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ SpringBootApplication 来标注一个主程序，说明这是一个spring boot应用
 * @author lhang
 * @create 2020-08-13 17:50
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //spring应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}

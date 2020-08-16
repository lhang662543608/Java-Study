package _06_data_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lhang
 * @create 2020-08-16 17:09
 */
@MapperScan(value = "_06_data_mybatis.mapper")
@SpringBootApplication
public class DataMybatisMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataMybatisMainApplication.class, args);
    }
}

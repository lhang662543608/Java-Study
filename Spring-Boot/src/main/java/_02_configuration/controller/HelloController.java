package _02_configuration.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lhang
 * @create 2020-08-14 9:24
 */
@Controller
@ResponseBody
public class HelloController {

    @Value("${person.last-name}")
    private String name;

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello"+ name;
    }
}

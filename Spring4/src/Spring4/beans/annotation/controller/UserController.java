package Spring4.beans.annotation.controller;

import Spring4.beans.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lhang
 * @create 2020-07-07 9:18
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void execute() {
        System.out.println("UserController execute...");
        userService.add();
    }
}

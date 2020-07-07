package Spring4.beans.annotation.service;

import Spring4.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author lhang
 * @create 2020-07-07 9:17
 */
@Service
public class UserService {
    @Autowired
    @Qualifier(value = "userRepository1")
    private UserRepository userRepository;

    public void add() {
        System.out.println("UserService add。。。");
        userRepository.save();
    }
}

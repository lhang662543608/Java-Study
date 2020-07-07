package Spring4.beans.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @author lhang
 * @create 2020-07-07 9:16
 */
@Repository(value = "userRepository1")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRepository Save....");
    }
}

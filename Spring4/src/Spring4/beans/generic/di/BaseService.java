package Spring4.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lhang
 * @create 2020-07-07 16:04
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository repository;

    public void add() {
        System.out.println("add..");
        System.out.println(repository);
    }
}

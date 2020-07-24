package springdata.dao;

import springdata.bean.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lhang
 * @create 2020-07-24 15:03
 */
public class PersonRepositoryImpl implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void test() {
        Person person = entityManager.find(Person.class, 11);
        System.out.println("  -->  " + person);
    }
}

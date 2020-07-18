package jpa.dao;

import jpa.spring.entities.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lhang
 * @create 2020-07-17 19:06
 */
@Repository
public class PersonDao {

    /**
     * 通过@PersistenceContext注解来标记成员变量
     */
    @PersistenceContext
    private EntityManager entityManager;

    public void persistPerson(Person person) {
        entityManager.persist(person);

    }
}

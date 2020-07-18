package jpa.service;

import jpa.dao.PersonDao;
import jpa.spring.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lhang
 * @create 2020-07-17 19:09
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public void persistPersons(Person person1, Person person2) {
        personDao.persistPerson(person1);

        personDao.persistPerson(person2);
    }
}

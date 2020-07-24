package springdata.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springdata.bean.Person;
import springdata.dao.PersonRepository;

import java.util.List;

/**
 * @author lhang
 * @create 2020-07-24 12:51
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void savePersons(List<Person> persons) {
        personRepository.save(persons);
    }

    @Transactional
    public void updatePersonEmail(Integer id, String email) {
        personRepository.updatePersonEmail(id, email);
    }
}

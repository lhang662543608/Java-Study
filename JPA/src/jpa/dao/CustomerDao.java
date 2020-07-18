package jpa.dao;

import jpa.spring.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author lhang
 * @create 2020-07-17 20:48
 */
@Repository
public class CustomerDao {
    @PersistenceContext
    EntityManager entityManager;

    public void persistCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer findCustomer(Integer id) {
       return entityManager.find(Customer.class, id);
    }

    public void removeCustomer(Integer id){
        Customer customer = entityManager.find(Customer.class, 2);
        entityManager.remove(customer);
    }
}

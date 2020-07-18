package jpa.service;

import jpa.dao.CustomerDao;
import jpa.spring.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lhang
 * @create 2020-07-17 20:48
 */
@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Transactional
    public void persistCustomer(Customer customer) {
        customerDao.persistCustomer(customer);
    }

    @Transactional
    public Customer findCustomer(Integer id) {
        return customerDao.findCustomer(id);
    }

    @Transactional
    public void removeCustomer(Integer id) {
        customerDao.removeCustomer(id);
    }
}

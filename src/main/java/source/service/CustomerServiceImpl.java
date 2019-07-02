package source.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import source.dao.CustomerDAO;
import source.entity.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject customerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomerById(Integer id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    @Transactional
    public void deleteCustomerById(Integer id) {
        customerDAO.deleteCustomerById(id);
    }

    @Override
    public List<Customer> getCustomersByLastName(String lastName) {
        return customerDAO.getCustomersByLastName(lastName);
    }


}

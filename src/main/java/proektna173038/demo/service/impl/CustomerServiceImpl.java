package proektna173038.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proektna173038.demo.model.Customer;
import proektna173038.demo.model.exceptions.InvalidArgumentsException;
import proektna173038.demo.repository.CustomerRepository;
import proektna173038.demo.service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getall() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getByID(Integer id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Integer id,Customer customer) {
        Customer pomCustomer=this.getByID(id);
        pomCustomer.setAddress(customer.getAddress());
        pomCustomer.setName(customer.getName());

        this.customerRepository.save(pomCustomer);

    }


    @Override
    public void deleteByID(Integer id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return customerRepository.findByUsernameAndPassword(username, password);

    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return this.customerRepository.findByUsernameAndPassword(username, password).orElse(null);
    }


}

package proektna173038.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proektna173038.demo.model.Customer;
import proektna173038.demo.model.exceptions.InvalidArgumentsException;
import proektna173038.demo.repository.CustomerRepository;
import proektna173038.demo.service.CustomerService;

import java.util.List;

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
    public List<Customer> login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
       // return customerRepository.save(username, password);
        return customerRepository.findAll();

                /*
                eturn userRepository.findByUsernameAndPassword(username,
                password)

                 */
    }
    @Override
    public Customer loginn(String username, String password){
        return (Customer) customerRepository.findAll();
    }

    @Override
    public Customer register(String username, String password ){
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidArgumentsException();

        Customer customer = new Customer(username,password);
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        return null;
    }
//
//    @Override
//    public Customer findByUsernameAndPassword(String username, String password) {
//        return this.customerRepository.findByUsernameAndPassword(username, password).orElse(null);
//    }


}

package proektna173038.demo.service;

import proektna173038.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    //CRUD
    void save(Customer customer);

    List<Customer> getall();

    Customer getByID(Integer id);

    void update(Integer id,Customer customer);

    void deleteByID(Integer id);

    List<Customer> login(String username, String password);

    Customer loginn(String username, String password);

    Customer register(String username, String password);

    Customer findByUsernameAndPassword(String username, String password);
}

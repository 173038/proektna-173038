package proektna173038.demo.service;

import proektna173038.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    //CRUD
    void save(Customer customer);

    List<Customer> getall();

    Customer getByID(Integer id);

    void update(Integer id,Customer customer);

    void deleteByID(Integer id);

    Optional<Customer> login(String username, String password);

    Customer findByUsernameAndPassword(String username, String password);
}

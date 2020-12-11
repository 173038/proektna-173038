package proektna173038.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proektna173038.demo.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   // public Optional<Customer> findByUsernameAndPassword(String username, String password);

  //  Customer register(String username, String password);



}

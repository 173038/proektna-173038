package proektna173038.demo.repository;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proektna173038.demo.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
}

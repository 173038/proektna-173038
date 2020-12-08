package proektna173038.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proektna173038.demo.model.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}

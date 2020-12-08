package proektna173038.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proektna173038.demo.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
}

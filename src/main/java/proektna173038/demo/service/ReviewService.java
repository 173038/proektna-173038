package proektna173038.demo.service;


import proektna173038.demo.model.Review;

import java.util.List;

public interface ReviewService {
    //CRUD
    void save(Review review);

    List<Review> getall();

    Review getByID(Integer id);

    void update(Integer id,Review review);

    void deleteByID(Integer id);
}

package proektna173038.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proektna173038.demo.model.Review;
import proektna173038.demo.repository.ReviewRepository;
import proektna173038.demo.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void save(Review review) {
        this.reviewRepository.save(review);

    }

    @Override
    public List<Review> getall() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Review getByID(Integer id) {
        return this.reviewRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Integer id,Review review) {
        Review pomReview=this.getByID(id);

        pomReview.setComment(review.getComment());
        pomReview.setRating(review.getRating());

        this.save(pomReview);

    }

    @Override
    public void deleteByID(Integer id) {
        this.reviewRepository.deleteById(id);
    }
}

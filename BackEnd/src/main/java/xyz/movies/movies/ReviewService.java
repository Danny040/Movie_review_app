package xyz.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate; // this is also a way to talk to a db in addition to repository
    // template is used to form a new dynamic query

    // 1st it looks for a movie with imdbId then it associates a review with this movie
    public Review createReview(String reviewBody, String imdbId) {

        Review review = reviewRepository.insert(new Review(reviewBody)); // insert returns a data that's just been pushed into a db

        // updates and pushes reviews into reviewIds array in movie class/item in db
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))//matching imdbId in db with imdbId received from user
                .apply(new Update().push("reviewIds").value(review))
                .first();//make sure that I get a single movie

        return review;
    }
}

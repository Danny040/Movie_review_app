// this is repository interface that deals with database
package xyz.movies.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // this tells framework that this is repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    // this is dynamic query bellow. but it works only for unique values
    Optional<Movie> findMovieByImdbId(String imdbId);
}

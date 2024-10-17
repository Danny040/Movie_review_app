package xyz.movies.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies") // this tells the framework that this class represents each movie in the collection
@Data // it takes care of all getters and setters for below fields
@AllArgsConstructor // creates a constructor for all below fields and takes them as arguments
@NoArgsConstructor // creates a constructor that doesn't take any arguments
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private List<String> genres;
    private String poster;
    private List<String> backdrops;
    @DocumentReference // manual reference relationship
    // this stores reviewIds in movies collection and creates a new collections for reviews
    private List<Review> reviewIds;
}

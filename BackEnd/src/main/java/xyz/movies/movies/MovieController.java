package xyz.movies.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//API controller handles requests and response back to caller
@RestController
@RequestMapping("api/v1/movies") // any request to the endpoint "api..." will be handled by below controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @CrossOrigin(origins = "*") // allows cross-origin resource sharing
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{imdbId}")//pathvar tells the framework that id in mapping is passed as path to the below method and converted to ObjectId
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}

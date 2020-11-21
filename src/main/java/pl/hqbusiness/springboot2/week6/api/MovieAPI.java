package pl.hqbusiness.springboot2.week6.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.hqbusiness.springboot2.week6.model.Movie;
import pl.hqbusiness.springboot2.week6.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
public class MovieAPI {

  private MovieService movieService;

  public MovieAPI(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<Movie>> getMovies() {
    return ResponseEntity.ok(movieService.getMovies());
  }

  @PostMapping
  public ResponseEntity<Void> addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie)
        ? ResponseEntity.ok().build()
        : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}

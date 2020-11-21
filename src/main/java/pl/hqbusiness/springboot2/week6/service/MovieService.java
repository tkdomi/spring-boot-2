package pl.hqbusiness.springboot2.week6.service;

import org.springframework.stereotype.Service;
import pl.hqbusiness.springboot2.week6.aspect.SendEmail;
import pl.hqbusiness.springboot2.week6.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

  private static final List<Movie> movies = new ArrayList<>(Arrays.asList(
      new Movie("Movie 1" , 1999, "X"),
      new Movie("Movie 2" , 2005, "Y"),
      new Movie("Movie 3" , 2019, "Z")
  ));

  public List<Movie> getMovies() {
    return movies;
  }

  @SendEmail
  public boolean addMovie(Movie movie) {
    System.out.println("add movie");
    return movies.add(movie);
  }
}

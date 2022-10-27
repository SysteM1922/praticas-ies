package com.example.ex33.service;

import com.example.ex33.model.Movie;
import com.example.ex33.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow();
    }

    public Movie postMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}

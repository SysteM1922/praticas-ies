package com.example.ex33.controller;

import com.example.ex33.model.Movie;
import com.example.ex33.model.Quote;
import com.example.ex33.service.MovieService;
import com.example.ex33.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable(value = "id") Long movieId) {
        return movieService.getMovie(movieId);
    }

    @GetMapping("/quote")
    public Quote getRandomQuote(@RequestParam(value = "movie", required = false) Long movieId) {
        if (movieId != null)
            return quoteService.getQuoteByMovie(movieId);
        return quoteService.getRandomQuote();
    }

    @GetMapping("/quotes")
    public List<Quote> getQuotesByMovie(@RequestParam(value = "movie", defaultValue = "") long movieId) {
        return quoteService.getQuotesByMovie(movieId);
    }

    @GetMapping("/quotes/{id}")
    public Quote getQuote(@PathVariable(value = "id") Long quoteId) {
        return quoteService.getQuote(quoteId);
    }

    @PostMapping("/movies")
    public Movie postMovie(@Valid @RequestBody Movie movie) {
        return movieService.postMovie(movie);
    }

    @PostMapping("/quote")
    public Quote postQuote(@Valid @RequestBody Quote quote) {
        return quoteService.postQuote(quote);
    }

}

package com.example.ex33.service;

import com.example.ex33.model.Quote;
import com.example.ex33.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Quote getRandomQuote() {
        Random rand = new Random();
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.get(rand.nextInt(quotes.size()));
    }

    public Quote getQuoteByMovie(Long movieId) {
        Random rand = new Random();
        List<Quote> quotes = this.getQuotesByMovie(movieId);
        return quotes.get(rand.nextInt(quotes.size()));
    }

    public List<Quote> getQuotesByMovie(long movieId) {
        List<Quote> quotes = quoteRepository.findAll();
        quotes.removeIf(quote -> quote.getMovie().getId() != movieId);
        return quotes;
    }

    public Quote getQuote(Long quoteId) {
        return quoteRepository.findById(quoteId).orElseThrow();
    }

    public Quote postQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

}

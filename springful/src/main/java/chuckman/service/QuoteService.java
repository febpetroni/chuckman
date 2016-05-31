package chuckman.service;

import chuckman.jokesource.JokeSource;
import chuckman.jokesource.Joke;
import chuckman.model.Quote;
import chuckman.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fernando on 27/05/16.
 */
@Component
public class QuoteService {

    @Autowired
    @Qualifier("chuckNorrisDatabaseJokeSource")
    private JokeSource jokeSource;
    @Autowired
    private QuoteRepository quoteRepository;

    public QuoteService() {
        System.out.println("*****CREATING QuoteService*****");
    }

    public List<Quote> getQuotes (String firstName, String lastName) {
        List<Quote> quotes = quoteRepository.findAllByName(firstName, lastName);
        System.out.println(quotes);
        return quotes;
    }

    public Quote createQuote (String firstName, String lastName) {
        Joke joke = jokeSource.randomJoke(firstName, lastName);
        Quote newQuote = new Quote(firstName, lastName, joke.getValue().getJoke(), joke.getValue().getId());
        quoteRepository.save(newQuote);
        System.out.println(newQuote);
        return newQuote;
    }

}

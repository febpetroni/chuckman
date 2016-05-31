package chuckman.service;

import chuckman.jokesource.JokeSource;
import chuckman.jokesource.icndb.ChuckNorrisDatabaseJokeSource;
import chuckman.jokesource.Joke;
import chuckman.model.Quote;
import chuckman.repository.QuoteRepository;

import java.util.List;

/**
 * Created by fernando on 27/05/16.
 */
public class QuoteService {

    private JokeSource jokeSource;
    private QuoteRepository quoteRepository;

    public QuoteService() {
        System.out.println("*****CREATING QuoteService*****");
        jokeSource = new ChuckNorrisDatabaseJokeSource();
        quoteRepository = new QuoteRepository();
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

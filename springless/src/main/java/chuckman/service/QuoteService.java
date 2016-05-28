package chuckman.service;

import chuckman.icndb.ChuckNorrisDatabase;
import chuckman.icndb.data.Joke;
import chuckman.model.Quote;
import chuckman.repository.QuoteRepository;

import java.util.List;

/**
 * Created by fernando on 27/05/16.
 */
public class QuoteService {

    private ChuckNorrisDatabase chuckNorrisDatabase;
    private QuoteRepository quoteRepository;

    public QuoteService() {
        System.out.println("*****CREATING QuoteService*****");
        chuckNorrisDatabase = new ChuckNorrisDatabase();
        quoteRepository = new QuoteRepository();
    }

    public List<Quote> getQuotes (String firstName, String lastName) {
        List<Quote> quotes = quoteRepository.findAllByName(firstName, lastName);
        System.out.println(quotes);
        return quotes;
    }

    public Quote createQuote (String firstName, String lastName) {
        Joke joke = chuckNorrisDatabase.randomJoke(firstName, lastName);
        Quote newQuote = new Quote(firstName, lastName, joke.getValue().getJoke(), joke.getValue().getId());
        quoteRepository.save(newQuote);
        System.out.println(newQuote);
        return newQuote;
    }

}

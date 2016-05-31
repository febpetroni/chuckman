package chuckman.jokesource.icndb;

import chuckman.jokesource.JokeSource;
import chuckman.jokesource.Joke;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by fernando on 27/05/16.
 */
public class ChuckNorrisDatabaseJokeSource implements JokeSource {

    private IcndbAPI icndbAPI;

    public ChuckNorrisDatabaseJokeSource() {
        System.out.println("*****CREATING ChuckNorrisDatabaseJokeSource*****");
        Feign.Builder builder = Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder())
                .options(new Request.Options(10000, 1000)).logger(new Logger.ErrorLogger()).logLevel(Logger.Level.FULL);
        this.icndbAPI = builder.target(IcndbAPI.class, "http://api.icndb.com/");
    }

    public Joke randomJoke(String firstName, String lastName) {
        return this.icndbAPI.randomJoke(firstName, lastName);
    }
}

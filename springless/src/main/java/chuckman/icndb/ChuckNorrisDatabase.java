package chuckman.icndb;

import chuckman.icndb.data.Joke;
import feign.Feign;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

/**
 * Created by fernando on 27/05/16.
 */
public class ChuckNorrisDatabase {

    private IcndbAPI icndbAPI;

    public ChuckNorrisDatabase() {
        System.out.println("*****CREATING ChuckNorrisDatabase*****");
        Feign.Builder builder = Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder())
                .options(new Request.Options(10000, 500));
        this.icndbAPI = builder.target(IcndbAPI.class, "http://api.icndb.com/");
    }

    public Joke randomJoke(String firstName, String lastName) {
        return this.icndbAPI.randomJoke(firstName, lastName);
    }
}

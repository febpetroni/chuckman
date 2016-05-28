package chuckman.jokesource;

import chuckman.jokesource.icndb.data.Joke;

/**
 * Created by fernando on 28/05/16.
 */
public interface JokeSource {

    Joke randomJoke(String firstName, String lastName);
}

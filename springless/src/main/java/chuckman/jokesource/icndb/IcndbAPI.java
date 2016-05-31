package chuckman.jokesource.icndb;

import chuckman.jokesource.Joke;
import feign.Param;
import feign.RequestLine;

/**
 * Created by fernando on 27/05/16.
 */
public interface IcndbAPI {

    @RequestLine("GET /jokes/random?firstName={fn}&lastName={ln}")
    Joke randomJoke(@Param("fn") final String firstName, @Param("ln") final String lastName);
}

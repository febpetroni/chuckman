package chuckman.jokesource.memory;

import chuckman.jokesource.JokeSource;
import chuckman.jokesource.Joke;

import java.util.Random;

/**
 * Created by fernando.petroni on 5/31/16.
 */
public class MemoryJokeSource implements JokeSource {

    private Joke[] jokes = new Joke[]{
            new Joke(1, "Chuck Norris uses ribbed condoms inside out, so he gets the pleasure."),
            new Joke(2, "MacGyver can build an airplane out of gum and paper clips. Chuck Norris can kill him and take it."),
            new Joke(3, "Chuck Norris doesn't read books. He stares them down until he gets the information he wants."),
            new Joke(4, "If you ask Chuck Norris what time it is, he always answers &quot;Two seconds till&quot;. " +
                    "After you ask &quot;Two seconds to what?&quot;, he roundhouse kicks you in the face."),
            new Joke(5, "Chuck Norris lost his virginity before his dad did."),
            new Joke(6, "Since 1940, the year Chuck Norris was born, roundhouse kick related deaths have increased 13,000 percent."),
            new Joke(12, "Chuck Norris sheds his skin twice a year."),
            new Joke(13, "Chuck Norris once challenged Lance Armstrong in a &quot;Who has more testicles?&quot; contest. " +
                    "Chuck Norris won by 5."),
            new Joke(14, "There are no steroids in baseball. Just players Chuck Norris has breathed on."),
            new Joke(15, "When Chuck Norris goes to donate blood, he declines the syringe, " +
                    "and instead requests a hand gun and a bucket."),
    };

    public MemoryJokeSource() {
        System.out.println("*****CREATING MemoryJokeSource*****");
    }

    public Joke randomJoke(String firstName, String lastName) {
        Random random = new Random();
        Joke joke = jokes[random.nextInt(jokes.length)];
        return replaceName(joke, firstName, lastName);
    }

    private Joke replaceName(Joke source, String firstName, String lastName) {
        String replaced = source.getValue().getJoke().replaceAll("Chuck", firstName)
                .replaceAll("Norris", lastName);
        return new Joke(source.getValue().getId(), replaced);
    }
}

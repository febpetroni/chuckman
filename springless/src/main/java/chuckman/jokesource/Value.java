package chuckman.jokesource;

/**
 * Created by fernando on 27/05/16.
 */
public class Value {

    private int id;
    private String joke;

    public Value() {}

    public Value(int id, String joke) {
        this.id = id;
        this.joke = joke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}

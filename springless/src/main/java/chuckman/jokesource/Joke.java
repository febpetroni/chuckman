package chuckman.jokesource;

/**
 * Created by fernando on 27/05/16.
 */
public class Joke {

    private String type;
    private Value value;

    public Joke() {}

    public Joke(int id, String joke) {
        this.type = "Success";
        this.value = new Value(id, joke);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}

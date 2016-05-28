package chuckman.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by fernando on 27/05/16.
 */
@XmlRootElement
public class Quote {

    private String firstName;
    private String lastName;
    private String joke;
    private Integer quoteId;

    public Quote(){}

    public Quote(String firstName, String lastName, String joke, Integer quoteId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joke = joke;
        this.quoteId = quoteId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Integer getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joke='" + joke + '\'' +
                ", quoteId=" + quoteId +
                '}';
    }
}

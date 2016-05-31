package chuckman.repository;

import chuckman.model.Quote;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 27/05/16.
 */
@Component
public class QuoteRepository {

    @Autowired
    private MongoDatabase database;

    public QuoteRepository() {
        System.out.println("*****CREATING QuoteRepository*****");
    }

    public List<Quote> findAllByName(String firstName, String lastName) {
        MongoCollection<Document> quotes = database.getCollection("quotes");

        MongoCursor<Document> iterator = quotes.find(Filters.and(
                Filters.eq("firstName", firstName),
                Filters.eq("lastName", lastName)
        )).iterator();

        List<Quote> result = new ArrayList<Quote>();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            result.add(new Quote(
                    doc.getString("firstName"), doc.getString("lastName"),
                    doc.getString("joke"), doc.getInteger("quoteId")));
        }

        return result;
    }

    public void save(Quote newQuote) {
        MongoCollection<Document> quotes = database.getCollection("quotes");

        Document doc = new Document().append("firstName", newQuote.getFirstName())
                .append("lastName", newQuote.getLastName())
                .append("joke", newQuote.getJoke())
                .append("quoteId", newQuote.getQuoteId());

        quotes.insertOne(doc);
    }

}

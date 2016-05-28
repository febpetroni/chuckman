package chuckman.api;

import chuckman.model.Quote;
import chuckman.service.QuoteService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by fernando on 27/05/16.
 */
@Path("/quotes")
@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
@Produces(MediaType.APPLICATION_JSON)
public class QuoteAPI {

    private QuoteService quoteService;

    public QuoteAPI() {
        System.out.println("*****CREATING QuoteAPI*****");
        quoteService = new QuoteService();
    }

    @GET
    public Response getQuotes (@QueryParam("firstName") final String firstName,
                              @QueryParam("lastName") final String lastName) {
        System.out.println("Received GET first = " + firstName + ", last = " + lastName);
        List<Quote> quotes = quoteService.getQuotes(firstName, lastName);
        GenericEntity<List<Quote>> listGenericEntity = new GenericEntity<List<Quote>>(quotes){};
        return Response.ok().entity(listGenericEntity).build();
    }

    @POST
    public Quote createQuote (@QueryParam("firstName") final String firstName,
                                 @QueryParam("lastName") final String lastName) {
        System.out.println("Received POST first = " + firstName + ", last = " + lastName);
        Quote newQuote = quoteService.createQuote(firstName, lastName);
        return newQuote;
    }
}

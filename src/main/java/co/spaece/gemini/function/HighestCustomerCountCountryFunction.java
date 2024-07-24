package co.spaece.gemini.function;

import java.util.function.Function;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonClassDescription("Get the country with the highest number of customers")
public class HighestCustomerCountCountryFunction implements Function<HighestCustomerCountCountryFunction.Request, HighestCustomerCountCountryFunction.Response> {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonClassDescription("Country with the highest number of customer database query")
	public record Request() {
	
	}
	
	public record Response(String country) {
	
	}
	
	@Override
	public Response apply(Request request) {
		return new Response("USA");
	}
}

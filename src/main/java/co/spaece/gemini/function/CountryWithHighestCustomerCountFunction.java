package co.spaece.gemini.function;

import java.util.function.Function;

import co.spaece.gemini.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonClassDescription("Get the country with the highest number of customers")
public class CountryWithHighestCustomerCountFunction implements Function<CountryWithHighestCustomerCountFunction.Request, CountryWithHighestCustomerCountFunction.Response> {
	private final CustomerRepository customerRepository;
	
	public CountryWithHighestCustomerCountFunction(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonClassDescription("Country with the highest number of customer database query")
	public record Request() {
	
	}
	
	public record Response(String country) {
	
	}
	
	@Override
	public Response apply(Request request) {
		String country = customerRepository.getCountryWithHighestCustomerCount();
		return new Response(country);
	}
}

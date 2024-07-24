package co.spaece.gemini.function;

import java.util.function.Function;

import co.spaece.gemini.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Get the number of customers in a given country")
public class CustomerCountByCountry implements Function<CustomerCountByCountry.Request, CustomerCountByCountry.Response> {
	private final CustomerRepository customerRepository;
	
	public CustomerCountByCountry(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public Response apply(Request request) {
		Long count = customerRepository.countByCountry(request.country);
		return new Response(count);
	}
	
	/**
	 * Customer Count by Country Function request.
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonClassDescription("Customer Count Database Query request")
	public record Request(@JsonProperty(required = true,
			value = "country") @JsonPropertyDescription("The country e.g. USA") String country) {
	}
	
	public record Response(Long count) {
	}
	
}

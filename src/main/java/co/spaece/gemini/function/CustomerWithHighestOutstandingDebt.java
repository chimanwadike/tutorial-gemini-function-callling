package co.spaece.gemini.function;

import java.util.function.Function;

import co.spaece.gemini.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonClassDescription("Get the customer with highest outstanding debt")
public class CustomerWithHighestOutstandingDebt implements Function<CustomerWithHighestOutstandingDebt.Request, CustomerWithHighestOutstandingDebt.Response> {
	private final CustomerRepository customerRepository;
	
	public CustomerWithHighestOutstandingDebt(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonClassDescription("Customer with the highest outstanding debt database query")
	public record Request() {
	
	}
	
	public record Response(String name) {
	
	}
	
	@Override
	public Response apply(Request request) {
		String name = customerRepository.getTop1HighestDebtCustomer();
		return new Response(name);
	}

}

package co.spaece.gemini.config;

import co.spaece.gemini.function.CustomerCountByCountryFunction;
import co.spaece.gemini.function.CountryWithHighestCustomerCountFunction;
import co.spaece.gemini.function.CustomerWithHighestOutstandingDebt;
import co.spaece.gemini.repository.CustomerRepository;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public FunctionCallback customerCountByCountryFunctionInfo(CustomerRepository customerRepository) {
		
		return FunctionCallbackWrapper.builder(new CustomerCountByCountryFunction(customerRepository))
				.withName("CustomerCountByCountry")
				.withDescription("Get the number of customers in a given country")
				.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA)
				.build();
	}
	
	@Bean
	public FunctionCallback countryWithHighestCustomerFunctionInfo(CustomerRepository customerRepository) {
		return FunctionCallbackWrapper.builder(new CountryWithHighestCustomerCountFunction(customerRepository))
				.withName("CountryWithHighestCustomerCount")
				.withDescription("Get the country with the highest customer count")
				.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA)
				.build();
	}
	
	@Bean
	public FunctionCallback customerWithHighestOutstandingDebtFunctionInfo(CustomerRepository customerRepository) {
		return FunctionCallbackWrapper.builder(new CustomerWithHighestOutstandingDebt( customerRepository))
				.withName("CustomerWithHighestOutstandingDebt")
				.withDescription("Get the country with the highest customer count")
				.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA)
				.build();
	}
}

package co.spaece.gemini.config;

import co.spaece.gemini.function.HighestCustomerCountCountryFunction;
import co.spaece.gemini.function.WeatherFunction;
import co.spaece.gemini.repository.CustomerRepository;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public FunctionCallback weatherFunctionInfo() {
		
		return FunctionCallbackWrapper.builder(new WeatherFunction())
				.withName("CurrentWeather")
				.withDescription("Get the current weather in a given location")
				.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA)
				.build();
	}
	
	@Bean
	public FunctionCallback countryWithHighestCustomerFunctionInfo(CustomerRepository customerRepository) {
		return FunctionCallbackWrapper.builder(new HighestCustomerCountCountryFunction(customerRepository))
				.withName("CountryWithHighestCustomerCount")
				.withDescription("Get the country with the highest customer count")
				.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA)
				.build();
	}
}

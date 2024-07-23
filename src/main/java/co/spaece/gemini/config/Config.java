package co.spaece.gemini.config;

import co.spaece.gemini.service.WeatherService;
import org.springframework.ai.model.function.FunctionCallback;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public FunctionCallback weatherFunctionInfo() {
		
		return FunctionCallbackWrapper.builder(new WeatherService())
				.withName("CurrentWeather") // (1) function name
				.withDescription("Get the current weather in a given location") // (2) function description
				.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA) // (3) schema type. Compulsory for Gemini function calling.
				.build();
	}
}

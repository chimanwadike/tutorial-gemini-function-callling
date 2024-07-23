package co.spaece.gemini.service;

import java.util.function.Function;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonClassDescription("Get the weather in location")
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {
	/**
	 * Temperature units.
	 */
	public enum Unit {
		
		/**
		 * Celsius.
		 */
		C("metric"),
		/**
		 * Fahrenheit.
		 */
		F("imperial");
		
		/**
		 * Human readable unit name.
		 */
		public final String unitName;
		
		private Unit(String text) {
			this.unitName = text;
		}
		
	}
	
	/**
	 * Weather Function request.
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonClassDescription("Weather API request")
	public record Request(@JsonProperty(required = true,
			value = "location") @JsonPropertyDescription("The city and state e.g. San Francisco, CA") String location,
	                      @JsonProperty(required = true, value = "unit") @JsonPropertyDescription("Temperature unit") Unit unit) {
	}
	
	public record Response(double temp, Unit unit) {
	}
	
	@Override
	public Response apply(Request request) {
		return new Response(20.0, Unit.C);
	}
}

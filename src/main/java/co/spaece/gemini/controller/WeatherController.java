package co.spaece.gemini.controller;

import java.util.List;
import java.util.Map;

import co.spaece.gemini.service.WeatherService;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.function.FunctionCallbackWrapper;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	private final VertexAiGeminiChatModel chatModel;
	
	@Autowired
	public WeatherController(VertexAiGeminiChatModel chatModel) {
		this.chatModel = chatModel;
	}
	
	@GetMapping("/weather/generate")
	public Map generate() {
		UserMessage userMessage = new UserMessage("What's the weather like in San Francisco?. Use celsius measurement.");

		var promptOptions = VertexAiGeminiChatOptions.builder()
				.withFunctionCallbacks(List.of(FunctionCallbackWrapper.builder(new WeatherService())
						.withName("CurrentWeather")
						.withSchemaType(FunctionCallbackWrapper.Builder.SchemaType.OPEN_API_SCHEMA) // IMPORTANT!!
						.withDescription("Get the weather in location")
						.build()))
				.build();

		ChatResponse response = chatModel.call(new Prompt(List.of(userMessage), promptOptions));

		return Map.of("weather", response);
	}
}

package co.spaece.gemini.service;

import java.util.List;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	private final VertexAiGeminiChatModel chatModel;
	private final VertexAiGeminiChatOptions promptOptions;
	
	public ChatService(VertexAiGeminiChatModel chatModel) {
		this.chatModel = chatModel;
		this.promptOptions = VertexAiGeminiChatOptions.builder()
				.withFunction("CountryWithHighestCustomerCount")
				.withFunction("CustomerCountByCountry")
				.withFunction("CustomerWithHighestOutstandingDebt")
				.build();
	}
	
	public String request(String message) {
		UserMessage userMessage = new UserMessage(message);
		ChatResponse response = chatModel.call(new Prompt(List.of(userMessage), promptOptions));
		return response.getResult().getOutput().getContent();
	}
}

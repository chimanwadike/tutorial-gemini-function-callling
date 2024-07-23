package co.spaece.gemini.controller;

import java.util.Map;

import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	private final VertexAiGeminiChatModel chatModel;
	
	@Autowired
	public TestController(VertexAiGeminiChatModel chatModel) {
		this.chatModel = chatModel;
	}
	
	@GetMapping("/ai/generate")
	public Map generate() {
		return Map.of("generation", chatModel.call("Tell me a joke"));
	}
}

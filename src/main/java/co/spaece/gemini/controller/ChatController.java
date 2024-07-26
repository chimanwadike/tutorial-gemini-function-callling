package co.spaece.gemini.controller;

import java.util.Map;

import co.spaece.gemini.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	
	private final ChatService chatService;
	
	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}
	
	@PostMapping("/chat")
	public Map generate(@RequestBody String message) {
		String response = chatService.request(message);
		return Map.of("result", response);
	}
}

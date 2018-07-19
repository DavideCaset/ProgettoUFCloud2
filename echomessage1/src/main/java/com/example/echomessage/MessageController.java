package com.example.echomessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope

public class MessageController {

	@Value("${echomessage: Hello default!}")
	private String message;
	
	@GetMapping("/message")
	public String message() {
		return message;
	}
}

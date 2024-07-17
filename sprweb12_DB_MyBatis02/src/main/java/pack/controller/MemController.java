package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemController {
	@GetMapping("/") // 요청이 없다는 뜻
	public String start() {
		return "start";
	}
	
}

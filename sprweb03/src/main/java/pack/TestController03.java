package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController03 {
	@RequestMapping("/java/korea")
	public String ghi(Model model) {
		model.addAttribute("msg", "성공 /java/korea");
		return "list";
	}
	
	@RequestMapping(value={"/java/korea", "nice", "ok"})
	public String ghi2(Model model) {
		model.addAttribute("msg", "여러 개의 요청이 한 개의 메소드와 매핑될 수 있다.");
		return "list";
	}
}
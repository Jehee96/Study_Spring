package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController { // pack 패키지와 동등한 위치에 있으면 스캔을 해야하므로 그 안에다 따로 만들어야 한다?
	
	@GetMapping("thymeleaf")
	public String start(Model model) {
		model.addAttribute("msg", "타임리프 쿠쿠");
		model.addAttribute("msg02", "저녁은 마라탕🍜");
		
		// DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("삼다수 3L");
		sangpum.setPrice("3000");
		model.addAttribute("sangpum", sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("고구마빵");
		sangpum.setPrice("2000");
		list.add(sangpum);
		
		model.addAttribute("list", list);
		
		return "list01"; // list1.html(서버에서 수행되는 html임) : 포워딩. 자동으로 templates 폴더로 찾아간다.
	}
}
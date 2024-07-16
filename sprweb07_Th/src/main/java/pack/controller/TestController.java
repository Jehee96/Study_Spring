package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "thleaf")
public class TestController {
	@GetMapping("/ex01")
	public String abc01(Model model) {
		ItemDTO dto = new ItemDTO();
		dto.setId("ks01");
		dto.setName("마우스");
		dto.setPrice(5000);
		dto.setRegDate(LocalDate.now());
		
		model.addAttribute("dto", dto);
		
		return "show01";
	}
	
	@GetMapping("/ex02")
	public ModelAndView abc02() {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		for(int i = 1; i <= 3; i++) {
			ItemDTO dto = new ItemDTO();
			dto.setId("ks" + i);
			dto.setName("신상품" + i);
			dto.setPrice(1000 * i);
			dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		ModelAndView andView = new ModelAndView("show02");
		andView.addObject("dtos", list);
		
		return andView;
	}
	
	@GetMapping("/ex03")
	public String abc03(Model model) {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		for(int i = 1; i <= 5; i++) {
			ItemDTO dto = new ItemDTO();
			dto.setId("ks" + i);
			dto.setName("신상품" + i);
			list.add(dto);
		}
		
		model.addAttribute("dtos", list);
		
		return "show03";
	}
	
	@GetMapping("/ex04")
	public String abc04(Model model, @RequestParam ("param01") String param01, @RequestParam ("param02") String param02) {
		System.out.println(param01 + " " + param02);
		
		model.addAttribute("arg01", param01);
		model.addAttribute("arg02", param02);
		return "show04";
	}
		// 레이아웃
		@GetMapping("/ex5")
		public String method5() {
			
			return "show5";
	}
}

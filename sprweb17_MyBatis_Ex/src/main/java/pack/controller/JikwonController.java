package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.JikwonDAO;

@Controller
public class JikwonController {
	@Autowired
	private JikwonDAO dao;
	
	@GetMapping("/")
	public String home() {
	    return "redirect:/list";
	}
	
	@GetMapping("/list") // @RequestMapping : get과 post를 다 받겠다는 얘기
	public String list(Model model) {
		List<JikwonDAO> list =  dao.list();
		model.addAttribute("list", list);
		return "list";
	}
	
	@PostMapping("/search")
	public String search(JikwonBean bean, Model model) {
		List<JikwonDAO> list =  dao.search(bean);
		model.addAttribute("list", list);
		return "list";
	}
}

package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pack.model.MemberDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InsertController {
	@Autowired
	public MemberDAO memberDAO;
	
	
	@ModelAttribute("command")
	public MemberBean formBack() {
		return new MemberBean();
	}
	
	
	@GetMapping("insert")
	public String form() {
		return "insform";
	}
	
	
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		memberDAO.insData(bean);
		
		return "redirect:/list"; // redirect : 클라이언트를 거치면 추가 후 목록 보기가 가능함
		//return "list"; : list를 바로 부르면 추가된 내용이 보이지 않는다. (=포워딩하면 추가된 내용이 보이지 않는다.)
	}
	
}

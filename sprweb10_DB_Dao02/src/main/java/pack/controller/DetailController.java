package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDAO;
import pack.model.MemberDTO;

@Controller
public class DetailController {
	@Autowired
	private MemberDAO memberDAO;
	
	@GetMapping("detail")
	public String detailProcess(@RequestParam("id")String id, Model model) {
		MemberDTO dto = memberDAO.getMember(id);
		model.addAttribute("member", dto);
		return "detail";
	}
}

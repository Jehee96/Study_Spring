package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.MemberDAO;
import pack.model.MemberDTO;

@Controller
public class ListControll {
	@Autowired
	private MemberDAO memberDAO; // DB처리담당
	
	
	@GetMapping("list")
	public String listProcess(Model model) {
		List<MemberDTO> list = memberDAO.getMemberList(); // SQL문장 실행
		
		model.addAttribute("list", list);
		return "list";
	}
}

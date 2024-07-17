package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDAO;
import pack.model.MemberDTO;

@Controller
public class UpdateController {
	@Autowired
	private MemberDAO memberDAO;
	
	
//	@GetMapping("update")
//	public String updateForm(@RequestParam("id")String id, Model model) {
//		MemberDTO dto = memberDAO.getMember(id);
//		model.addAttribute("member",dto);
//		return "update";
//	}
//	
//	
//	@PostMapping("update")
//	public String updateProcess(@RequestParam("id")String id, Model model) {
//		MemberDTO dto = memberDAO.getMember(id);
//		model.addAttribute("member",dto);
//		return "redirect:list";
//	}
	
	@GetMapping("update")
    public String updateForm(@RequestParam("id") String id, Model model) {
        MemberDTO dto = memberDAO.getMember(id);
        model.addAttribute("member", dto);
        return "update";
    }

    @PostMapping("update")
    public String updateProcess(MemberBean memberBean, Model model) {
        memberDAO.upData(memberBean);
        return "redirect:/list";
    }
}

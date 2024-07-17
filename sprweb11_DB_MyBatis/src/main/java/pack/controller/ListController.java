package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDAO;
import pack.model.SangpumDto;

@Controller
public class ListController {
	@Autowired // 포함관계
	private DataDAO dataDAO;
	
	@GetMapping("mybatis")
	public String listProcess(Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDAO.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("search")
	public String searchProcess(FormBean bean, Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDAO.getDataSearch(bean);
		model.addAttribute("datas", list);
		return "list";
	}
}

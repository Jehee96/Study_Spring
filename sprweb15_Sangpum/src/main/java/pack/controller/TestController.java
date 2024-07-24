package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDAO;
import pack.model.Sangpum;

@Controller
public class TestController {
	
	@Autowired
	private DataDAO dataDAO;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("testjpa")
	public String list(Model model) {
		ArrayList<Sangpum> slist = (ArrayList<Sangpum>)dataDAO.getDataAll();
		model.addAttribute("datas", slist);
		return "list";
	}
	
	@GetMapping("search")
	public String searchlist(FormBean bean ,Model model) {
		ArrayList<Sangpum> slist = (ArrayList<Sangpum>)dataDAO.getDataSearch(bean.getSearchValue());
		model.addAttribute("datas", slist);
		return "list";
	}
}

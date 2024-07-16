package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;


@Controller
public class JikwonController {

	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwondb")
	public String listProcess(@RequestParam(value = "jik")String jik, Model model) {
		ArrayList<JikwonDto> list = dataDao.selectAll(jik);
		int cnt = dataDao.countJikwon(jik);
		model.addAttribute("datas", list);
		model.addAttribute("count", cnt);
	
		return "list";
	}
}

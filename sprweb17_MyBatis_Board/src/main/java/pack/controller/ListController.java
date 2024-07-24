package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.Board;
import pack.model.BoardDAO;

@Controller
public class ListController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("list") // @RequestMapping : get과 post를 다 받겠다는 얘기
	public String list(Model model) {
		ArrayList<Board> list =  (ArrayList<Board>)dao.list();
		model.addAttribute("list", list);
		return "list";
	}
}

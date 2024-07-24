package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDAO;

@Controller
public class DeleteController {
	@Autowired
	private BoardDAO dao;

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteSummit(BoardBean bean) {
		boolean b = dao.deleteData(bean);
		
		if(b) {
			return "redirect:/list";
		}else {
			return "error";
		}
	}
}

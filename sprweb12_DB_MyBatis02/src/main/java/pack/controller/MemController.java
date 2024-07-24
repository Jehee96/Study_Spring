package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemDTO;

@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/") // 요청이 없다는 뜻? 메인으로..
	public String start() {
		return "start";
	}
	
	@GetMapping("list") // list요청
	public String list(Model model) {
		ArrayList<MemDTO> list = (ArrayList<MemDTO>)dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(MemBean bean) {
		boolean b = dataProcess.insert(bean);
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";
	}
	
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	
	@GetMapping("update")
	public String update(@RequestParam("num") String num, Model model) {
		MemDTO dto = dataProcess.getData(num);
		model.addAttribute("data", dto);
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemBean bean) {
		boolean b = dataProcess.update(bean);
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";
	}
	
	
	@GetMapping("delete")
	public String delete(@RequestParam("num") String num) {
		boolean b = dataProcess.delete(num);
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";
	}

}

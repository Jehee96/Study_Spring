package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.Mem;


@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String main() {
		return "start"; // start.html이 list를 부름
	}
	
	// 전체 자료 읽기
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>)dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(MemBean bean, Model model) {
		String msg = dataProcess.insert(bean);
		if(msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error"; // 중복됐거나 실패했을 경우
		}
	}
	
	// 수정
	@GetMapping("update")
	public String update(@RequestParam("num") String num, Model model) {
		//System.out.println("num : " + num);
		Mem mem = dataProcess.getData(num);
		
		model.addAttribute("data", mem);
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemBean bean, Model model) {
		String msg = dataProcess.update(bean);
		if(msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error"; // 중복됐거나 실패했을 경우
		}
	}
	
	
	@RequestMapping("delete")
	public String deleteProcess(@RequestParam("num") int num, Model model) {
		String msg = dataProcess.delete(num);
		if(msg.equals("success"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error"; // 중복됐거나 실패했을 경우
		}
	}
	
}
package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test09")
public class TestController02 {
	//@RequestMapping(method=RequestMethod.GET) // @@RequestMapping value 부분을 위로 빼고 이렇게 쓸 수도 있다.
	//@RequestMapping(value="test09", method=RequestMethod.GET) // get 요청 처리(원래..)
	public String def1(Model model) {
		model.addAttribute("msg", "success get");
		return "list"; // 포워딩
	}
	
	@RequestMapping(value="test09", method=RequestMethod.POST) // post 요청 처리
	public String def2(Model model) {
		model.addAttribute("msg", "success post");
		return "list";
	}
}

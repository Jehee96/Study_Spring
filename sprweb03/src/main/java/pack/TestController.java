package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

//@RestController // @Controller + @ResponseBody. return값을 XML이나 Json으로 해줌. 
//public class TestController {
//	@RequestMapping("test1")
//	public String abc() {
//		return "요청에 대한 반응 보이기";
//	}
	
	
@Controller // 사용자의 요청을 받아서 처리한 후 지정된 뷰(템플릿 엔진:jsp...)에 모델 객체를 넘겨주는 역할을 한다.
public class TestController {
	@RequestMapping("test01") // get, post 모두 처리
	public ModelAndView abc() {
		//System.out.println("abc 처리");
		//return null;
		//return new ModelAndView("list", "msg", "안녕 jsp"); // view파일명 : list, ModelAndView : msg(Key), 안녕jsp(Value)
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		//request.setAttribute("list", "msg", "안녕 jsp")
		// HTTPServletRequest를 사용해 키, 값으로 JSP에 전송
		modelAndView.addObject("msg", "안녕 jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="test02", method=RequestMethod.GET) // get 요청 처리
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공02");
	}
	
	@GetMapping("test03") // get 요청 처리
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공03");
	}
	
	@GetMapping("test04") // get 요청 처리
	public String abc4(Model model) { // Model이 곧 Request
		model.addAttribute("msg", "성공04");
		return "list";
	}
	
	@RequestMapping(value="test05", method=RequestMethod.POST) // post 요청 처리
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공05");
	}
	
	@PostMapping("test06") // post 요청 처리
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공06");
	}
	
	@PostMapping("test07") // post 요청 처리
	public String abc7(Model model) {
		model.addAttribute("msg", "성공07");
		return "list"; // Model이 있으면 String이 아닌 View파일명이라는 것을 명심
	}
	
	@GetMapping("test08") // get 요청 처리
	@ResponseBody //일반 데이터_String, Map, JSON 등을 그대로 리턴한다.
	public String abc8() {
		String value = "일반 데이터_String, Map, JSON 등을 전달할 수 있다.";
		return value;
	}
	
	@GetMapping("test08_1") // get 요청 처리
	@ResponseBody
	public DataDTO abc8_1() {
		DataDTO dto = new DataDTO();
		dto.setCode(10);
		dto.setName("톰아저씨");
		return dto; // JSON 형태로 반환 (Jackson 라이브러리가 지원)
	}
}
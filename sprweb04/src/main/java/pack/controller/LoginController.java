package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	// 로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // 현재 클래스에 적용
	
	
	@GetMapping("login")
	public String submitCall() {
		//return "login.html" // forward : 기본값
		return "redirect:login.html"; // redirect 명시적으로 적어줘야 한다.
		//return "redirect:http://localhost/login.html";
	}
	
	// 클라이언트가 전달한 값 수신방법 01 : 전통적인 방법
//	@PostMapping("login")
//	public String submit(HttpServletRequest request, Model model) { // String을 썼기 때문에 Model이 필요함
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		System.out.println(id + " " + pw);
//		logger.info(id + " " + pw); // 로그레벨 trace > debug > info > warn > error > fatal
//		
//		String data = "";
//		
//		if(id.equals("kor") && pw.equals("111"))
//			data = "로그인 성공!";
//		else
//			data = "로그인 실패!";
//		
//		model.addAttribute("data", data);
//		return "result"; // views 폴더에 들어있는 forwarding
//	}
	
	// 클라이언트가 전달한 값 수신방법 02 : Spring Annotation 사용
	@PostMapping("login")
	public String submit(@RequestParam(value="id")String id, 
			//@RequestParam(value="pw")String pw, Model model) {
			//@RequestParam(value="pw")int pw, Model model) { // 숫자로 넘겨받고 싶으면 숫자로 넘길 부분을 int로 선언한다.
			@RequestParam(value="pw", defaultValue="111")int pw, Model model) { // 초기치를 줄 수도 있다. 문자열로 쓰고 int로 선언하면 자동으로 int로 변환해준다.
		
		String data = "";
		
		//if(id.equals("kor") && pw.equals("111"))
		if(id.equals("kor") && pw == 111) // type을 number로 했어도 숫자모양의 '문자'로 넘어오게 된다.
			data = "로그인 성공!";
		else
			data = "로그인 실패!";
		
		model.addAttribute("data", data);
		
		return "result";
	}
}
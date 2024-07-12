package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sangpum { // DTO클래스. @컴포넌트를 안한 이유는 TestController에서 NEW해야 하기 때문
	private String code, sang, price;
	
}
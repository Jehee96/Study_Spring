package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController02 {
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons() {
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		// 01
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "공기밥");
		data.put("age", "23");
		dataList.add(data);
		
		// 02
		data = new HashMap<String, String>();
		data.put("name", "고봉밥");
		data.put("age", "25");
		dataList.add(data);
		
		// 03
		data = new HashMap<String, String>();
		data.put("name", "비빔밥");
		data.put("age", "21");
		dataList.add(data);
		//return data;
		System.out.println("data : " + data);
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList : " + dataList);
		// dataList : [{name=공기밥, age=23}, {name=고봉밥, age=25}, {name=비빔밥, age=21}]
		// @ResponseBody에 의해 {"datas":[{"name":"공기밥","age":"23"},{"name":"고봉밥","age":"25"},{"name":"비빔밥","age":"21"}]} k-v형식으로 JSON타입으로 변함!
		
		return data2;
	}
}

package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.JikwonDto;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataPrint1() {
		// 전체 직원 정보
		List<JikwonDto> jlist = dataInterface.selectAllJikwon();		
		System.out.println("직원 정보:");
		for(JikwonDto j : jlist) {
			System.out.println(j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_num() + " " + j.getJikwon_ibsail());
		}
	}
	
	public void dataPrint2() {
		
		// 부서별 인원 수
		List<Object> blist = dataInterface.selectAllBuser();
		System.out.println(blist);
		System.out.println("\n부서별 인원수:");
		for(Object b : blist) {
			Integer buserNum = (Integer)blist.get(0);
			Long count = (Long)blist.get(1);
			System.out.println(buserNum + ": " + count);
		}
		
	}
}

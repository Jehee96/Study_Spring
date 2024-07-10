package pack.model;

import java.util.List;

public interface DataInterface {
	List<JikwonDto> selectAllJikwon(); // 전체 직원 정보 반환
	List<Object> selectAllBuser(); // 전체 부서 반환
}

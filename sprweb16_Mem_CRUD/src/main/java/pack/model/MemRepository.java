package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemRepository extends JpaRepository<Mem, Integer> {
	// num 자동 증가용
	@Query(value = "select max(m.num) from Mem as m")
	//@Query(value = "select max(num) from Mem", nativeQuery = true)
	int findByMaxNum();
	
	
	@Query("select m from Mem as m where m.num=?1") // Mem : JPA 영역 내에서 쓰이는 클래스
	Mem findByNum(String num);
}

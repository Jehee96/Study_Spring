package pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
	
	// 최대 number 값 구하기
	@Query("SELECT MAX(f.number) FROM Friend f")
	Integer findLastNumber();
	
}	

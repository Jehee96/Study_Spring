package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friend {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY); // number 칼럼이 auto_incrrement일 때
	private int number;
	private String name;
	private String tel;
	private String job;
	
	// 사진
	@Lob // BLOB, CLOB 타입으로 처리
	private byte[] pic;
	private String imagetype;
	
	@Transient // DB와 관련 없는 임시 데이터 저장용
	private String base64Image; // base64로 인코딩된 이미지 타입
}

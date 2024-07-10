package pack;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.crypto.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jikwon")
public class Jikwon {
	@Id
	@Column(name = "jikwon_no")
	private int jikwonNo;
	
	@Column(name = "jikwon_name")
	private String jikwonName;
	
	
	@ManyToOne // jikwon 엔티티에 buser를 걸음
	@JoinColumn(name = "buser_num", referencedColumnName = "buser_no") // referencedColumnName : 외래 키가 참조하는 대상 테이블의 컬럼명
	private Buser buser;
	
	@Column(name = "jikwon_ibsail")
	private Date jikwonIbasil;
}
package pack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "buser")
public class Buser {
	@Id
	@Column(name = "buser_no") // DB 실제 칼럼명을 써야함
	private int buserNo;
	
	@Column(name = "buser_name")
	private String buserName;
}
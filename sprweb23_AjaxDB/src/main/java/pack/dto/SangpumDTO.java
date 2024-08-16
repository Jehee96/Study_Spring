package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pack.entity.Sangpum;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SangpumDTO {
	private int code;
	private String sang, su, dan;
	
	public static SangpumDTO toDto(Sangpum sangpum) {
		return SangpumDTO.builder()
				.code(sangpum.getCode())
				.sang(sangpum.getSang())
				.su(sangpum.getSu())
				.dan(sangpum.getDan())
				.build();
	}
}

package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.SangpumDTO;
import pack.entity.Sangpum;

@Repository
public class DataDAO {
	@Autowired
	private DataRepository dataRepository;
	
	public List<SangpumDTO> getSangpumAll() {
		List<SangpumDTO> slist = dataRepository.findAll().stream()
			.map(sangpum -> SangpumDTO.builder()
					.code(sangpum.getCode())
					.sang(sangpum.getSang())
					.su(sangpum.getSu())
					.dan(sangpum.getDan())
					.build())
					.collect(Collectors.toList());
		return slist;
	}
}

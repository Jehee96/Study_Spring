package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pack.controller.JikwonBean;

@Mapper
public interface DataMapInterface {
	// 추상 메소드명은 mapper.xml의 아이디명과 일치시킨다.
	List<JikwonDAO> selectList();
	List<JikwonDAO> selectSearch(JikwonBean bean);
}

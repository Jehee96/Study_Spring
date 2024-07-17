package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.MemBean;

@Mapper // 마커 인터페이스
public interface DataMapperInterface {
	@Select("select * from mem") // 전체
	List<MemDTO> selectAll();
	
	@Select("select * from mem where num=#{num}") // 부분
	List<MemDTO> selectPart(String num);
	
	@Insert("insert into mem values(#{num},#{name},#{addr})") // 추가
	int insertData(MemBean bean);
	
	@Update("update mem set name=#{name}, addr=#{addr} where num=#{num}") // 수정
	int updatetData(MemBean bean);
	
	@Delete("delete from mem where num=#{num}") // 삭제
	int deleteData(String num);
}

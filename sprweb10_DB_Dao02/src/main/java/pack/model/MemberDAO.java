package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDAO extends JdbcDaoSupport {
	
	@Autowired // 생성자..
	public MemberDAO(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	// 전체 자료 읽기
	public List<MemberDTO> getMemberList() {
		String sql = "select * from membertab";
		
		// 내부 무명클래스
//		List<MemberDTO> list = getJdbcTemplate().query(sql, new RowMapper() {
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberDTO member = new MemberDTO();
//				member.setId(rs.getString("id"));
//				member.setName(rs.getString("name"));
//				member.setPasswd(rs.getString("passwd"));
//				member.setReg_date(rs.getString("reg_date"));
//				return member;
//			}
//		});
		
		// 람다 표현식 사용
		List<MemberDTO> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDTO member = new MemberDTO();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
		
		return list;
	}
	
	// 추가
	public void insData(MemberBean bean) {
		String sql = "insert into membertab values(?,?,?,now())";
		
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()};
 		getJdbcTemplate().update(sql, params);
 		// update(sql, bean) : bean을 들고 가면 안됨
	}
	
	// 수정
	
	
	// 삭제
 }
package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {
	// JdbcDaoSupport : dataSource, jdbcTemplate <-- getter, setter 有
	
	// 데이터 소스 넣기. DB 정보를 가지고 있어야 함
	@Autowired // 생성자 인젝션
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	public List<SangpumDto> getDataAll() {
		String sql = "select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper()); // List 형식으로 캐스팅. 쿼리는 jdbcTemplate가 제공함.
	}
	
	class ItemRowMapper implements RowMapper<Object> {
		
		@Override // mapRow 오버라이드
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// DB에서 읽힌 자료를 SangpumDto에게..
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}

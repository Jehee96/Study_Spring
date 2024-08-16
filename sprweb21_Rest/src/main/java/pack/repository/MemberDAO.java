package pack.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession session;

	// 회원자료 전체 읽기
	public List<MemberDTO> getList() {
		return session.selectList("member.getList");
	}

	// 자료 추가
	public void insert(MemberDTO dto) {
		session.insert("member.insert", dto);
	}

	// 하나의 회원자료 읽기
	public MemberDTO getData(int num) {
		return session.selectOne("member.getData", num);
	}

	// 자료 수정
	public void update(MemberDTO dto) {
		session.update("member.update", dto);
	}

	// 자료 삭제
	public void delete(int num) {
		session.delete("member.delete", num);
	}

}
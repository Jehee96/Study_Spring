package pack;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
											// 엔티티 클래스(ProductVO), ProductVO의 프라이머리 키 타입(Integer)
public interface ProductCRUD_Repository extends CrudRepository<ProductVO, Integer> {
	// save(), findById(ID id), findAll(), count(), deleteById(ID id), delete(T entity), deleteAll() .. 지원 받음

	// CrudRepository > PagingAndSortingRepository > JpaRepository
	// JpaRepository는 CrudRepository, PagingAndSortingRepository에 구현된 기능을 모두 가지고 있다.
	
	// JPA 쿼리 메소드 사용(메소드 이름으로 쿼리 생성 방법 : find + (엔티티 이름) + By + (변수 이름))
	// 엔티티 이름은 생략 가능
	ProductVO findByCode(Integer code);
	
	// JPQL
	@Query(value = "select p from ProductVo as p")  // 물리적인 이름 product를 쓰면 안됨.
	List<ProductVO> findAllData();
	
	// where 조건 : 이름 기반
	@Query(value = "select p from ProductVo as p where p.code=:code")
	ProductVO findByCodeMy(@Param("code") int code);
	
	// where 조건 : 순서 기반
	@Query(value = "select p from ProductVo as p where p.code=?1")
	ProductVO findByCodeMy2(int code);
	
	@Query(value = "select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVO> findByData(int code, String sang);
}

package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {
	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");  // DB 연결 정보 : 인수 값은 persistence.xml의 <persistence-unit name="hello"> name 속성에 해당
		EntityManager em = emf.createEntityManager();  // 엔티티의 생명주기를 관리. CRUD를 수행한다.
		EntityTransaction tx = em.getTransaction();    // 트랜잭션(Transaction)을 관리하는 인터페이스 , commit, rollback 등을 수행한다.
		
		List<MemDto> list = null;
		
		try {
			// 레코드 추가
//			tx.begin();
//			MemDto dto1 = new MemDto();
//			dto1.setNumber(4);
//			dto1.setName("홍길동");
//			dto1.setAddr("서초구 방배동");
//			em.persist(dto1);
//			tx.commit();
			// Hibernate: /* insert pack.model.MemDto */ 
			// 실제 SQL 처리 : insert into mem (addr, name, num) values (?, ?, ?)
			
			
			// 레코드 수정
//			tx.begin();
//			MemDto mdto2 = em.find(MemDto.class, 4);
//			mdto2.setName("신길동");
//			tx.commit();
			// Hibernate: /* update pack.model.MemDto */ 
			// 실제 SQL 처리 : update mem set addr=?, name=? where num=?
			
			
			// 레코드 삭제
//			tx.begin();
//			MemDto mdto3 = em.find(MemDto.class, 4);
//			em.remove(mdto3);
//			tx.commit();
			
			
			// 레코드 하나 읽기
			System.out.println("부분 자료 읽기(단일 엔티티) find() 메소드 사용");
			MemDto mdto = em.find(MemDto.class, 1);  // 두 번째 인자로 PK 전달, '1'을 전달했으므로 PK인 num 값이 1인 데이터 출력을 위한 메소드 작성
			System.out.println(mdto.getNumber() + " " + mdto.getName() + " " + mdto.getAddr());
			
			
			System.out.println("부분 자료 읽기(복수 엔티티)");
			List<MemDto> listPart = findByAddr(em, "진관");
			for(MemDto m : listPart) {
				System.out.println(m.getNumber() + " " + m.getName() + " " + m.getAddr());
			}
			
			// 전체 레코드 읽기
			System.out.println("전체 자료 읽기(JPQL 사용)");
			/*
			list = findAll(em, MemDto.class); // 두 번째 인자로 엔티티 클래스 전달한다.
			for(MemDto m : list) {
				System.out.println(m.getNumber() + " " + m.getName() + " " + m.getAddr());
			}
			*/
			
			list = em.createQuery("select e from MemDto as e", MemDto.class).getResultList();
			// Hibernate(JPQL) ==> select e from MemDto e, RDBMS에 관계없이 공통적으로 사용
			// Hibernate가 DBDialect를 보고 실제 SQL문으로 변환한다.
			// select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_
		
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
		

		
		
		return list;
	}
	
	public List<MemDto> findByAddr(EntityManager em, String ss) {
		// Addr 필드가 특정 접두사로 시작하는 레코드 읽기
		String jpql = "SELECT m FROM MemDto m WHERE m.addr LIKE : ss"; // 조건은 콜론(:)으로 준다. addr이 ss로 시작되는 것을 찾는다.
		
		TypedQuery<MemDto> query = em.createQuery(jpql, MemDto.class);
		// TypedQuery<Entity> query = em.createQuery(jpql, EntityClass);
		// 👆JPQL을 작성하고 실행하는 역할을 한다.
		query.setParameter("ss", "%" + ss + "%"); // @@동 할 때
		//query.setParameter("ss", ss + "%"); // SQL의 LIKE 연산 검색문자%
		return query.getResultList(); // 쿼리 실행 후 리스트로(복수) 반환
	}
	
	
	public<T> List<T> findAll(EntityManager em, Class<T> cla) {
		// select 문의 경우, SQL문이 아닌 JPQL임.
		// cla.getName() : pack.model.DataDto
		// cla.getSimpleName() : DataDto
		System.out.println(cla.getSimpleName());
		return em.createQuery("select e from " + cla.getSimpleName() + " e", cla).getResultList();  // 테이블에 대한 별명을 'e'로 설정
	}
}

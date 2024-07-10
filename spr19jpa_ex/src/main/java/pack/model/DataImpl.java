package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface{
	EntityManagerFactory emf;
	EntityManager em;
	List<JikwonDto> list;
	
	@Override
	public List<JikwonDto> selectAllJikwon() {
		emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 속 persistence-unit의 이름
		em = emf.createEntityManager(); // entity의 life span(생명주기)를 관리하고 CRUD를 수행. 내부적으로 Thread 생성
		list = em.createQuery("select j from JikwonDto as j", JikwonDto.class).getResultList();
		em.close();
		emf.close();
		
		
		return list;
	}

	@Override
	public List<Object> selectAllBuser() {
		List<Object> result = null;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("hello"); // persistence.xml 속 persistence-unit의 이름
		EntityManager em1 = emf1.createEntityManager(); // entity의 life span(생명주기)를 관리하고 CRUD를 수행. 내부적으로 Thread 생성
		result = em1.createQuery("select j.buser_num, count(j) FROM JikwonDto as j group by j.buser_num", Object.class).getResultList();
		
		em1.close();
		emf1.close();
		
		return result;
	}
}

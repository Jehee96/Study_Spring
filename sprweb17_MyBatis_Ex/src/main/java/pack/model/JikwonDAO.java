package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.JikwonBean;

@Repository
public class JikwonDAO {
	@Autowired
	private DataMapInterface mapInterface;
	
	public List<JikwonDAO> list() {
		return mapInterface.selectList();
	}

	// 검색
	public List<JikwonDAO> search(JikwonBean bean) {
		return mapInterface.selectSearch(bean);
	}

}

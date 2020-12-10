package spring.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

// <bean id="board">
@Service("board")
public class BoardDaoImpl implements DaoService {

	public List selectAll() throws Exception {
		return null;
	}

	public Object selectOne(String id) throws Exception {
		return null;
	}
}

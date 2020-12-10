package spring.model.service;

import java.util.List;

import org.apache.catalina.LifecycleListener;

public interface DaoService {

	// Dao 구현에 필요한 내용을 작성한다.
	// Dao = 파일 / DBMS / 엑셀 .. 등 저장할수있는 방법을 구현한다.

	public static final String dbConnect = "jdbc/orcl";

	// 전체정보 가져오기 
	public List selectAll() throws Exception;
	
	// 하나정보 가져오기 
	public Object selectOne(String id)throws Exception;
	
	
	
}

package spring.model.service;

import java.util.List;
import java.util.concurrent.locks.Condition;

public interface BoardDaoService {

	// DB 연결 정보 정의!!
	// tomcat 서버 context.xml 커넥션풀 셋팅 정보 활용
	// oracle / mysql 선택
	// DB서버 URL 프로젝트 메뉴얼 참조
	// DB 서버 매주 금요일 (23시~01시) 점검
	public Condition getCondition() throws Exception;

	// 테이터 저장
	// num , writer , subject , content 필수
	// num / writer 유효섬사 코드 작성
	// writer = 현재로그인된 ID와 같아야한다.
	
	public void insertArticle(BoardDataBean article) throws Exception;

	//
	public int getArticleCount() throws Exception;

	//
	public List getArticles(int start, int end) throws Exception;

	//
	public BoardDataBean getArticle(int num) throws Exception;

	//
	public BoardDataBean updateGetArticle(int num) throws Exception;

	//
	public int updateArticle(BoardDataBean article) throws Exception;

	//
	public int deleteArticle(int num, String passwd) throws Exception;

}

package spring.model.service;

import java.util.List;
import java.util.concurrent.locks.Condition;

public interface BoardDaoService {

	// DB ���� ���� ����!!
	// tomcat ���� context.xml Ŀ�ؼ�Ǯ ���� ���� Ȱ��
	// oracle / mysql ����
	// DB���� URL ������Ʈ �޴��� ����
	// DB ���� ���� �ݿ��� (23��~01��) ����
	public Condition getCondition() throws Exception;

	// ������ ����
	// num , writer , subject , content �ʼ�
	// num / writer ��ȿ���� �ڵ� �ۼ�
	// writer = ����α��ε� ID�� ���ƾ��Ѵ�.
	
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

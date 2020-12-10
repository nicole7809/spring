package spring.model.service;

import java.util.List;

import spring.model.FileDTO;

public interface FileService {

	// ���� �Է��ϰ� �۹�ȣ�� �����Ѵ�.
	public int fileInsert(FileDTO dto) throws Exception;

	public FileDTO selectNum(int num) throws Exception;

	public List selectId(String id) throws Exception;

	public void fileUpdate(FileDTO dto) throws Exception;

	public void fileDelete(int num) throws Exception;

	public List selectAll() throws Exception;

	public String selectId(int num) throws Exception;

	public String selectFile(FileDTO dto) throws Exception;
	
	public int selectCount()throws Exception;
}

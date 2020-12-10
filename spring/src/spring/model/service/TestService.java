package spring.model.service;

import java.util.List;

import spring.model.FileDTO;

public interface TestService {

	public FileDTO select(FileDTO dto) throws Exception;

	public void update(FileDTO dto) throws Exception;

	public List select(Object obj) throws Exception;
}

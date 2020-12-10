package spring.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.FileDTO;

@Service("fileDAO")
public class FileServiceMybatis implements FileService {

	@Autowired
	private SqlSessionTemplate dao = null;

	@Override
	public int fileInsert(FileDTO dto) throws Exception {

		return 0;
	}

	@Override
	public FileDTO selectNum(int num) throws Exception {

		return null;
	}

	@Override
	public List selectId(String id) throws Exception {
		dao.selectList("test.selectId", id);
		return null;
	}

	@Override
	public void fileUpdate(FileDTO dto) throws Exception {

	}

	@Override
	public void fileDelete(int num) throws Exception {

	}

	@Override
	public List selectAll() throws Exception {
		// selectList -select 결과 여러개일때.
		// selectOne -select 결과 하나일때.

		// SQL.xml 의 id속성으로 호출
		return dao.selectList("test.selectAll");

	}

	@Override
	public String selectId(int num) throws Exception {
		// id , parameterType 대입값
		return dao.selectOne("test.selectOne", num);
	}

	@Override
	public String selectFile(FileDTO dto) throws Exception {
		// return dao.selectOne("test.selectFile",dto);

		Map map = new HashMap();
		map.put("mid", "1231");
		map.put("mnum", "7");

		return dao.selectOne("test.selectMap", map);

	}

	@Override
	public int selectCount() throws Exception {

		return dao.selectOne("test.selectCount");
	}

}

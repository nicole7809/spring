package spring.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import spring.model.FileDTO;

@Service
public class FileServiceImpl implements FileService {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/orcl");
		return ds.getConnection();
	}

	@Override
	public int fileInsert(FileDTO dto) throws Exception {
		int num = 0;
		conn = getConnection();
		String sql = "insert into fileList(num,id,orgname,reg) values(fileList_seq.nextval,?,?,sysdate)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getOrgname());
		pstmt.executeUpdate();
		sql = "select max(num) from fileList";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			num = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return num;
	}

	@Override
	public FileDTO selectNum(int num) throws Exception {
		return null;
	}

	@Override
	public List selectId(String id) throws Exception {
		return null;
	}

	@Override
	public void fileUpdate(FileDTO dto) throws Exception {
		conn = getConnection();
		String sql = "update fileList set savename=? where num=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getSavename());
		pstmt.setInt(2, dto.getNum());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	@Override
	public void fileDelete(int num) throws Exception {
	}

	@Override
	public List selectAll() throws Exception {
		conn = getConnection();
		String sql = "select * from fileList";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
			FileDTO dto = new FileDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setOrgname(rs.getString("orgname"));
			dto.setSavename(rs.getString("savename"));
			dto.setReg(rs.getTimestamp("reg"));
			list.add(dto);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public String selectId(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectFile(FileDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}

package spring.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch11.logon.LogonDataBean;

@Service("memberDAO")
public class LogonDBServiceMybatis implements LogonDBService {

	@Autowired
	SqlSessionTemplate dao = null;

	@Override
	public void insertMember(LogonDataBean member) throws Exception {
		dao.insert("member.insertMember", member);

	}

	public int userCheck(LogonDataBean member) throws Exception {
		return dao.selectOne("member.userCheck", member);
	}

	@Override
	public int confirmId(LogonDataBean member) throws Exception {
		return dao.selectOne("member.userCheck", member);
	}

	@Override
	public LogonDataBean getMember(String id) throws Exception {
		return dao.selectOne("member.member", id);
	}

	@Override
	public void updateMember(LogonDataBean member) throws Exception {
		dao.update("member.updateMember", member);

	}

	public int deleteMember(LogonDataBean member) throws Exception {
		int check = dao.selectOne("member.deleteMember", member);
		if (check == 1) {
			dao.delete("member.deleteMember", member);
		}
		return check;
	}

}
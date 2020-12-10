package spring.model;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch11.logon.LogonDBBean;
import ch11.logon.LogonDataBean;

@Controller
@RequestMapping("/member/")
public class MemberBean {

	@Autowired
	private LogonDBBean memberDAO = null;

	@RequestMapping("main.do")
	public String main() {
		return "member/main";
	}

	@RequestMapping("inputForm.do")
	public String inputForm() {
		return "member/inputForm";
	}

	@RequestMapping(value = "inputPro.do", method = RequestMethod.POST)
	public String inputPro(LogonDataBean dto) throws Exception {
		memberDAO.insertMember(dto);
		return "member/inputPro";
	}

	@RequestMapping("confirmId.do")
	public String confirmId(String id, Model model) throws Exception {
		int check = memberDAO.confirmId(id);
		model.addAttribute("check", check);
		model.addAttribute("id", id);
		return "member/confirmId";
	}

	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "member/loginForm";
	}

	@RequestMapping("loginPro.do")
	public String loginPro(String id, String passwd, HttpSession session, Model model) throws Exception {
		int check = memberDAO.userCheck(id, passwd);
		if (check == 1) {
			session.setAttribute("memId", id);
		}
		model.addAttribute("check", check);
		return "member/loginPro";
	}

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/logout";
	}

	@RequestMapping("modify.do")
	public String modify() {
		return "member/modify";
	}

	@RequestMapping("modifyForm.do")
	public String modifyForm(HttpSession session, Model model) throws Exception {
		String id = (String) session.getAttribute("memId");
		LogonDataBean c = memberDAO.getMember(id);
		model.addAttribute("c", c);
		return "member/modifyForm";
	}

	@RequestMapping("modifyPro.do")
	public String modifyPro(LogonDataBean dto) throws Exception {
		memberDAO.updateMember(dto);
		return "member/modifyPro";
	}

	@RequestMapping("deleteForm.do")
	public String deleteForm() throws Exception {
		return "member/deleteForm";
	}

	@RequestMapping("deletePro.do")
	public String deletePro(HttpSession session, String passwd, Model model) throws Exception {
		String id = (String) session.getAttribute("memId");
		int check = memberDAO.deleteMember(id, passwd);
		if (check == 1) {
			session.invalidate();
		}
		model.addAttribute("check", check);
		return "member/deletePro";
	}
}

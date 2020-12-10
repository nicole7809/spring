package spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.service.DaoService;
import spring.model.service.TestService;

@Controller
@RequestMapping("/test/")
public class TestBean {

	/*
	 * @Autowired // 클래스이름 <bean id="" > 역할 // BoardDaoImpl = boardDaoImpl ,
	 * daoServiceimpl private DaoService board = null;
	 * 
	 * @RequestMapping("/test/service.do") public String Service() {
	 * System.out.println(board); return ""; }
	 * 
	 * @RequestMapping("/test/main.do") public String main() throws Exception {
	 * Class c = Class.forName("oracle.jdbc.driver.OracleDriver"); Object cn =
	 * c.newInstance(); System.out.println(cn); return "test/main"; }
	 */

	@Autowired
	private TestService testDAO = null;

	@RequestMapping("main.do")
	public String main(FileDTO dto, Model model) throws Exception {
		model.addAttribute("testDAO", testDAO.select(dto));
		return "1210/main";
	}

	@RequestMapping("update.do")
	public String update(FileDTO dto) throws Exception {
		testDAO.update(dto);
		return "1210/main";
	}

	@RequestMapping("select.do")
	public String selectFor(Model model) throws Exception {
		List list = new ArrayList();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(15);

		list = testDAO.select(list);
		model.addAttribute("list", list);
		return "1210/select";
	}
}
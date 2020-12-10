package spring.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // spring-servlet.xml ��Ʈ���� ��û�� �޴´�.
public class HelloBean {

	@Autowired // ����Ѱ� ����
	private Dto dto = null;

	@Autowired // ����Ѱ� ����
	private Dto dto2 = null;

	@Autowired // ����Ѱ� ����
	private Dto dto3 = null;

	@Autowired // ����Ѱ� ����
	private Dto dto4 = null;

	@Autowired // ����Ѱ� ����
	private Dto dto5 = null;

	@Autowired // ����Ѱ� ����
	private Date day = null;

	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("bean ����~!!");
		System.out.println(dto.getName());
		System.out.println(dto.getNum());
		System.out.println("----------------------");
		System.out.println(dto2.getName());
		System.out.println(dto2.getNum());
		System.out.println("----------------------");
		System.out.println(dto3.getName());
		System.out.println(dto3.getNum());
		System.out.println("----------------------");
		System.out.println(dto4.getName());
		System.out.println(dto4.getNum());
		System.out.println(dto4.getDay());
		System.out.println("----------------------");
		System.out.println(dto5.getName());
		System.out.println(dto5.getNum());
		System.out.println(dto5.getDay());

		return "1130/hello";
	}

	@RequestMapping("/pro.do")
	public String test(Dto dto, String name, int num, HttpServletRequest request, HttpSession session,
			HttpServletResponse response, Model model) {
		System.out.println(request);
		System.out.println(session);
		System.out.println(response);

		// .DAO ȣ����� ó���� �Ѵ�.
		// ó���� ����� view�� ������.
		// request.setAttribute();
		// session.setAttribute();
		// Model interface -- model �� ó�� ����� view �����ϱ����� ��ü
		// java.util.Map���� ���������.
		// view ���� ${ǥ�����}�� ����Ѵ�
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("dto", dto);

		return "1130/pro";
	}

	@RequestMapping("/pro2.do")
	public ModelAndView pro2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/1130/pro.jsp"); // view���
		mv.addObject("name", "nava"); // ���� ��!!
		mv.addObject("num", 300);
		return mv;
		// http://localhost:8080/spring/pro2.do
	}

	
}

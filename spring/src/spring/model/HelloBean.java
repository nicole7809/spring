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

@Controller // spring-servlet.xml 컨트롤의 요청을 받는다.
public class HelloBean {

	@Autowired // 컨드롤과 연결
	private Dto dto = null;

	@Autowired // 컨드롤과 연결
	private Dto dto2 = null;

	@Autowired // 컨드롤과 연결
	private Dto dto3 = null;

	@Autowired // 컨드롤과 연결
	private Dto dto4 = null;

	@Autowired // 컨드롤과 연결
	private Dto dto5 = null;

	@Autowired // 컨드롤과 연결
	private Date day = null;

	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("bean 실행~!!");
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

		// .DAO 호출등의 처리를 한다.
		// 처리된 결과를 view로 보낸다.
		// request.setAttribute();
		// session.setAttribute();
		// Model interface -- model 의 처리 결과를 view 전달하기위한 객체
		// java.util.Map으로 만들어졌다.
		// view 에서 ${표현언어}로 사용한다
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("dto", dto);

		return "1130/pro";
	}

	@RequestMapping("/pro2.do")
	public ModelAndView pro2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/1130/pro.jsp"); // view경로
		mv.addObject("name", "nava"); // 전달 값!!
		mv.addObject("num", 300);
		return mv;
		// http://localhost:8080/spring/pro2.do
	}

	
}

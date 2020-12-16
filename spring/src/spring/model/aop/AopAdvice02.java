package spring.model.aop;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
public class AopAdvice02 {

	private ServletRequest session;

	@Around("execution(public * spring.model..logon_*(..))")

	public Object around(ProceedingJoinPoint jp) throws Throwable {
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();
		
		Object view = "member/error";
		if (session != null) {
			if (session.getAttribute("memId") != null) {
				view = jp.proceed();
			}
		}
		return view;
	}

	/*
	 * @Before("execution(public * spring.model..main())") public void before() {
	 * System.out.println("before"); }
	 */

}

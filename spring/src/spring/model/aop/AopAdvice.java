package spring.model.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopAdvice {

	public void test() {
		System.out.println("aop advice run...!!");
	}

	public void after() {
		System.out.println("aop after run...!!!");
	}

	// Ÿ�� ��/�� ����
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		// System.out.println("Target==" + jp.getTarget());
		// System.out.println("Args==" + jp.getArgs());
		// System.out.println("Class==" + jp.getClass());
		// System.out.println("This==" + jp.getThis());
		// System.out.println("Signature==" + jp.getSignature());
		jp.proceed();
		return "1214/test"; // mvc �帧�� �̾��ش�.

	}

}

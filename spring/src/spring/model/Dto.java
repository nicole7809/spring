package spring.model;

import java.util.Date;

public class Dto {
	private String name;
	private int num;
	private Date day;

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	// 기본 생성자 - 매개변수가 없는 생성자
	public Dto() {
		System.out.println("Dto 생성~!!");
		this.name = "guest";
		this.num = 20;
	}

	public Dto(String name) {
		this.name = name;
		this.num = 20;
	}

	public Dto(String name, int num) {
		this.name = name;
		this.num = num;
	}

	public Dto(String name, int num, Date day) {
		this(name, num);
		this.day = day;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

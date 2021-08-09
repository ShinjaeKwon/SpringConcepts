package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //다음에 나오는 클래스인 Member 클래스를 빈으로 등록하겠다는 의미이다.
public class Member {
	//@Value 어노테이션은 세터의 역할을 수행하기에 객체가 생성될 때 값으르 가지고 만들 수 있도록 값의 지정이 가능하다.
	//또한 생성된 후 값을 바꿀 일이 없으면 하단 세터 부분의 코드는 필요 없지만 , 프로그램 수행 중에 내용이 바뀌어야 한다면 하단의 세터 부분을 이용해 값을 변경할 수 있다.
	
	@Value("홍길동") //변수의 기본값으로 홍길동 지정
	private String name; 
	
	@Value("도사")  //변수의 기본값으로 도사를 지정
 	private String nickname;
	
	//@Autowired 어노테이션은 해당 클래스의 객체를 찾아와 자동으로 연결한다. 컨테이너에 등록된 빈들 중에서 사용할 수 있는 객체를 자동으로 연결해주는데,
	//printerA, printerB 처럼 유사한 클래스가 여러 개 있는 경우에는 @Qualifier 어노테이션을 통해 이름을 명확하게 지정해줘야 한다.
	
	@Autowired //빈이 생성될 때 printer 변수가 참조할 객체를 자동으로 찾아준다.
	@Qualifier("printerA") //유사한 객체가 여러 개일 때 빈의 이름으로 정확하게 지정한다.
	private Printer printer;
	
	
	public Member() {}

	public Member(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNicknamme(String nickname) {
		this.nickname = nickname;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		printer.print("Hello "+name + " : "+nickname);
	}
	
	
	
	

}

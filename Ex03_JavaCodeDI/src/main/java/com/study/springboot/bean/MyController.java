package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //다음에 나오는 클래스를 빈으로 등록하겠다는 의미이다.
public class MyController {
	@Autowired //빈이 생성될 때 member1 변수가 참조할 객체를 자동으로 찾아온다. Member 클래스 타입으로 등록된 빈이 하나 밖에 없으므로 추가 정보가 없더고 잘 찾아올 수 있다.
	Member member1;
	@Autowired // 빈이 생성될 때 printer 변수가 참조할 객체를  자동으로 찾아온다,..
	@Qualifier("printerB") //유사한 객체가 여러 개 일 때 빈의 이름으로 정확하게 지정한다.
	Printer printer;
	@Autowired 
	Member member2;
	
	@RequestMapping("/") //웹 브라우저에서 사용자가 /로 get방식의 url 호출을 하면 다음 라인의 root() 메서드를 실행시킨다.
	public @ResponseBody String root() { // @ResponseBody : Json이나 Xml등 REST Api 형태의 응답을 할 경우, 다시 말해 html 태크 없이 순수하게 스트링 데이터만으로 응답을 할경우 지정
		
		//1. Member Bean 가져오기
		member1.print();
		
		//2. PrintB Bean 가져오기
		member1.setPrinter(printer);
		member1.print();
		
		//3. 싱글톤인지 확인
		if(member1 == member2) {
			System.out.println("동일한 객체입니다.");
		}else {
			System.out.println("서로 다른 객체입니다.");
		}
		
		return "Annotation 사용하기";
	}
}

//이 클래스에서 사용할 변수의 값은 이 클래스가 생성될 때 어노테이션에 의해 자동으로 의존 주입을 받아 할당받기 때문에 사용자는 별도의 세팅없이 바로 사용이 가능하다.

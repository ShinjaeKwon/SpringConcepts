package com.study.springboot.bean;

import org.springframework.stereotype.Component;

@Component("printerA") //다음에 나오는 클래스인 PrinterA 클래스를 빈으로 등록하겠다는 의미이다. 이때 등록할 이름으로 printerA를 사용하겠다고 이름도 지정한 것이다.
public class PrinterA implements Printer {

	@Override
	public void print(String message) {
		
		System.out.println("Printer A : "+message);
	}

}

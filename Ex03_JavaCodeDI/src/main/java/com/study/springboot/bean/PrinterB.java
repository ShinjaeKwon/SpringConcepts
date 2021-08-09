package com.study.springboot.bean;

import org.springframework.stereotype.Component;

@Component("printerB")// 다음에 나오는 클래스인 PrinterB 클래스를 빈으로 등록하겠다는 의미이다. 이때 등록할 이름으로 printerB를 사용하겠다고 이름도 지정한 것이다.
public class PrinterB implements Printer {

	@Override
	public void print(String message) {
		
		System.out.println("Printer B : "+message);

	}

}

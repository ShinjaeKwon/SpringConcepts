package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //
public class Ex03JavaCodeDiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex03JavaCodeDiApplication.class, args);
	}

}

//@SpringBootApplication의 의미
// 1. @Configuration : Bean을 생성할 때 Singletone으로 한번만 생성한다. 그리고 각종 설정을 세팅한다.
// 2. @EnableAutoConfiguration : 스프링 어플리케이션 컨텍스트(Application Context)를 만들 때 자동으로 설정하는 기능을 켠다. 
// 사용자가 필요할 것 같은 빈을 추측해서 ApplicationContext를 만들 때 필요한 설정을 한다. 
// 클래스 패스를 기준으로 클래스를 찾아 설정을 한다.
// 예를 들어 클래스 패스에 tomcat-embeded.jar이 있으면 TomcatEmbeddedServletContainerFactory가 있을 것이라고 추측해서 설정을 한다.
// 3. @ComponentScan : 지정한 위치 이하에 있는 @Component와 @Configuration이 붙은 클래스를 스캔해서 빈으로 등록한다.

// 프로그램이 실행되면 이 클래스의 main 메서드가 가장 처음으로 실행된다. 
// 이 때 이 클래스에 지정된 @SpringBootApplication 어노테이션을 통해 자동으로 빈을 검색하고 등록한 후 main 메서드의 SpringApplication.run을 통해서 
// 내장 톰캣을 실행한다음, 자동으로 Web ApplicationContext를 생성한다.

//스프링부트가 실행되면 스프링 부트는 IoC 컨테이너가 되어 오토 스캔에 의하여 지금처럼 어노테이션이 지정된 클래스들을 찾아 빈으로 등록한다.
// 이때 PrinterA 와 PrinterB는 @Component 어노테이션에 빈의 이름을 추가 정보로 입력하였다.
// 이렇게 입력된 이름이 빈의 이름으로 사용되고 Member처럼 빈의 이름을 입력하지 않고,
// @Component어노테이션만 지정하면 클래스 이름의 첫 글자를 소문자로 한 클래스의 이름이 빈의 이름으로 등록이 된다.

//우리가 만든 프로젝트는 스프링 부트로 만든 웹 프로젝트이다. 따라서 웹 브라우저에서 주소창에 URL을 입력하면 RequestMapping에 등록된 메서드가 호출이 되는 방식이다.
// 빈의 메서드를 호출하기 위해서도 이와 같은 방식을 사용해야 한다.

/*******************************************************************************************/
//브라우저에서 루트(/)를 호출하면 MyController의 root 메서드가 호출이 되고 콘솔창에 로그가 출력이 된다.

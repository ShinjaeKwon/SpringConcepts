package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "JSP in Gradle";
	}
	
	@RequestMapping("/test1") //url 매핑에 의하여 test1이 호출되면 @ResponseBody 어노테이션이 없기 때문에 17라인에서 리턴하는 이름에 아까 지정한 접두어와 접미어를 붙여서 
	//실제 이 폴더에가서 해당 파일을 찾아 실행하고 그 결과를 리턴하게 된다.
	public String test1() {
		return "test1";  //실제 호출될 /WEB-INF/views/test1.jsp 
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "sub/test2";  //실제 호출될 /WEB-INF/views/test1.jsp 
	}
	
}

//@RequestMapping("/test1") : url 매핑에 의하여 test1이 호출되면 @ResponseBody 어노테이션이 없기 때문에 17라인에서 리턴하는 이름에 아까 지정한 접두어와 접미어를 붙여서 
//실제 이 폴더에가서 해당 파일을 찾아 실행하고 그 결과를 리턴하게 된다.

//spring.mvc.view.prefix=/WEB-INF/views/ : 접두어
//spring.mvc.view.suffix=.jsp : 접미어 
//결과 = /WEB-INF/views/test1.jsp 호출 

//12 라인과 18라인에서 리턴하는 값은 똑같은 스트링 형태이지만 결과는 완전히 다르다.
// @ResponseBody 어노테이션이 메서드에 적용되어 있으면 리턴되는 스트링 값 자체만 웹 브라우저로 전달된다.
// @ResponseBody 어노테이션이 없다면 조합된 값으로 JSP 를 찾아 실행하고 그 결과를 웹 브라우저에게 전달한다.


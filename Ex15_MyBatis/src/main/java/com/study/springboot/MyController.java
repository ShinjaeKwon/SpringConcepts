package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.IMyUserDao;

@Controller
public class MyController {
	
	@Autowired
	private IMyUserDao userDao;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "MyBatis 사용하기";
	}
	
//	@GetMapping("/user")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.list());
		return "userlist";
	}
}
//15라인에서 자동 주입을 지정하고
//16라인에서 userDao 객체 변수를 만들었다.
//여기서 주목할 점은 자동 주입으로 만들어질 객체 변수의 값을 인터페이스 타입의 변수로 받았다는것이다
//매퍼를 사용했기에 현재 코드상에는 인터페이스를 구현한 클래스가 없기 때문이다.
//디자인 패턴에서 자주 사용하는 '자식 객체를 부모 타입의 변수에 대입'를 활용한 것이다.

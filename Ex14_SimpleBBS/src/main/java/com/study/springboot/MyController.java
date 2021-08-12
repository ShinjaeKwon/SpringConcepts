package com.study.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MyController {
	
	@Autowired //자동 주입을 지정하고 
	ISimpleBbsDao dao; //dao 객체 변수를 만들었다.
	
	@RequestMapping("/")
	public String root() throws Exception{
		// JdbcTemplate : SimpeBBS
		return "redirect:list";
//		redirect 기능을 활용해서 url로 /가 호출되면 url이 자동으로 /list로 연결이 되게 만들었다.
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		//게시판의 리스트를 출력하기위해 dao의 listDao() 메서드를 호출하여 리턴 값을 model 변수에 담는다.
		model.addAttribute("list", dao.listDao()); 
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String sId = request.getParameter("id");
		//개별 게시글을 보기 위해 dao의 viewDao 메서드를 호출하여 리턴값을 model 변수에 담는다.
		model.addAttribute("dto", dao.viewDao(sId));
        return "view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		//입력 폼을 가진 JSP 파일을 호출한다.
		 return "writeForm"; 
	}
	
	@RequestMapping("/write")
	public String write(Model model, HttpServletRequest request) {
//		폼의 입력값을 파라미터로 받아 dao의 writeDao 메서드를 호출해 데이터베이스에 insert를 한다
		dao.writeDao(request.getParameter("writer"),
					 request.getParameter("title"), 
					 request.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		dao.deleteDao(request.getParameter("id")); 
//		파라미터로 넘어온 값을 이용해 dao의 deleteDao 
//		메서드를 호출해 데이터베이스에서 게시글을 delete한다.
		return "redirect:list";
	}
	
}

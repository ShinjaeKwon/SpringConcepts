package com.study.springboot;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.service.ISimpleBbsService;

@Controller //클래스를 빈으로 등록하는데 컨트롤러로 사용 
public class MyController {
	
//	@Autowired
//	ISimpleBbsDao dao;
	
	@Autowired
	ISimpleBbsService bbs;
	
	@RequestMapping("/")
	public String root() throws Exception{
		//Service vs DAO
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
//		model.addAttribute("list", dao.listDao());
		//게시판의 리스트를 출력하기 위해 dao의 
		//listDao() 메서드를 호출하여 리턴값을 model 변수에 담는다
		model.addAttribute("list", bbs.list());
		
		int nTotalCount = bbs.count();
		System.out.println("Count : "+ nTotalCount);
		
		return "/list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String sId = request.getParameter("id");// 개별 게시글을 보기 위해 dao viewDao 메서드를
		//호출하여 리턴값을 model변수에 담는다
		model.addAttribute("dto", bbs.view(sId));
		return "/view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}
	
	@RequestMapping("/write") //폼의 입력값을 파라미터로 받아 dao의 writeDao 메서드를 호출해
	//데이터베이스에 insert 한다.
	public String write(HttpServletRequest request, Model model) {
//		dao.writeDao(request.getParameter("writer"),
//			     	 request.getParameter("title"),
//			     	 request.getParameter("content"));
		
		String sName = request.getParameter("writer");
		String sTitle = request.getParameter("title");
		String sContent = request.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", sName);
		map.put("item2", sTitle);
		map.put("item3", sContent);
		
		int nResult = bbs.write(map);
		System.out.println("Write : "+nResult);
		
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete") //파라미터로 넘어온 값을 이용해 dao의 deleteDao 메서드를 호출해
	//데이터 베이스에서 게시글을 delete 한다.
	public String delete(HttpServletRequest request, Model model) {
//		dao.deleteDao(request.getParameter("id"));
		String sId = request.getParameter("id");
		int nResult = bbs.delete(sId);
		System.out.println("Delete : "+nResult);
		return "redirect:list";
	}
}

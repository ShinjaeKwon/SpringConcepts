package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.service.IBuyTicketService;

@Controller
public class MyController {
	
	@Autowired
	IBuyTicketService buyTicket;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Transaction X (1)";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(@RequestParam("consumerId") String consumerId,
								  @RequestParam("amount") String amount,
								  @RequestParam("error") String error,
								  Model model) {
		//서비스의 buy 메서드 호출
		int nResult = buyTicket.buy(consumerId, Integer.parseInt(amount), error);
		
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("amount", amount);
		if(nResult == 1) { //1이면 정상적 
			return "buy_ticket_end";
		}else { //0이면 에러
			return "buy_ticket_error";
		}
	}
}

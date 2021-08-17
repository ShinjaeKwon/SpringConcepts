package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class BuyAndLogService {
	
	@Autowired
	BuyTicketService buyTicket;
	@Autowired
	LogWriteService logWrite;
	@Autowired
	TransactionTemplate transactionTemplate;
	
	public int buy(String comsumerId, int amount, String error) {
		
		try {
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					buyTicket.buy(comsumerId, amount, error); //티켓을 구매하는 서비스 메서드 호출
					
					//의도적 에러 발생
					if(error.equals("2")) {int n = 10/0;}
					
					logWrite.write(comsumerId, amount); //로그를 작성한느 서비스 메서드 호출
				}
			});
			return 1;
		}catch (Exception e) {
			System.out.println("[Transaction Propagation #1] Rollback");
			return 0;
		}
	}
}

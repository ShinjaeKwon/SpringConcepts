package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service //이 클래스를 빈으로 사용
public class BuyTicketService {

	@Autowired //자동 주입받아 변수를 만듬
	ITransaction1Dao transaction1;
	@Autowired //자동 주입받아 변수를 받음
	ITransaction2Dao transaction2;
	

	@Autowired //트랜잭션 템플릿을 사용하기 위한 변수를 선언하고 스프링으로부터 자동 주입
	TransactionTemplate transactionTemplate;
	
//	@Transactional(propagation = Propagation.REQUIRED)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public int buy(String consumerId, int amount, String error) {

		try {//트랜잭션을 적용할 부분을 트랜잭션 템플릿으로 감싼다.
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				//TransactionCallbackWithoutResult 메서드 안에 트랜잭션을 적용시킬 비즈니스 로직을 작성
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
			//doInTransactionWithoutResult 메서드 안에서 에러가 발생하지 않으면 정상적으로 커밋
			//에러가 발생하면 자동으로 롤백
					transaction1.pay(consumerId, amount);
					
					//의도적 에러 발생
					if(error.equals("1")) {int n = 10/0; }
					
					transaction2.pay(consumerId, amount);
					
				}
			});
				
			return 1;
		}catch (Exception e) {
			System.out.println("[Transaction Propagation #2] Rollback");
			return 0;
		}

	}
	
}

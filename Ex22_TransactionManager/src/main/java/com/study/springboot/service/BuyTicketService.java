package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service //이 클래스를 빈으로 사용
public class BuyTicketService implements IBuyTicketService {

	@Autowired //자동 주입받아 변수를 만듬
	ITransaction1Dao transaction1;
	@Autowired //자동 주입받아 변수를 받음
	ITransaction2Dao transaction2;
	
	@Autowired //트랜잭션 매니저 변수를 선언하고 스프링으로부터 자동주입
	PlatformTransactionManager transactionManager; 
	@Autowired // 트랜잭션 매니저에서 사용할 설정을 만드는데 설정값은 기본으로 제공되는 값으로
	TransactionDefinition definition;
	
	@Override
	public int buy(String consumerId, int amount, String error) {
	
		TransactionStatus status = transactionManager.getTransaction(definition); //트랜잭션 설정
		//이 처리 이후의 DB처리에 대해서 트랜잭션을 처리할 수 잇게 된다.
		try {
			transaction1.pay(consumerId, amount);
			
			//의도적 에러 발생
			if(error.equals("1")) {int n = 10/0; }
			
			transaction2.pay(consumerId, amount);
			
			transactionManager.commit(status);	//트랜잭션에 대한 커밋 처리
			//이전설정부터 지금까지의 데이터베이스 처리 결과에 대해서 커밋
			return 1;
		}catch (Exception e) {
			System.out.println("[PlatformTransactionManager] Rollback");
			transactionManager.rollback(status);//트랜잭션에 대한 롤백 처리
			//이전 설정부터 현재 까지의 데이터베이스 처리결과에데해서 롤백
			return 0;
		}

	}
	
}

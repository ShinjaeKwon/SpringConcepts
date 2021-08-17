package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ITransaction3Dao;

@Service
public class LogWriteService {
	
	@Autowired
	ITransaction3Dao transaction3;
	
	public int write(String consumerId, int amount) {
		
		try {
			transaction3.pay(consumerId, amount); //DAO를 호출하는 부분이 하나라 별도 트랜젹션 처리 X
			return 1;
		}catch (Exception e) {
			return 0;
		}
		
	}
}

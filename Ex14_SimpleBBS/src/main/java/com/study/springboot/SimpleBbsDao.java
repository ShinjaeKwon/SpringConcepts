package com.study.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springboot.dto.SimpleBbsDto;

@Repository //이 클래스를 데이터베이스 처리를 목적으로 하는 빈으로 등록한다는 어노테이션을 지정한다.
public class SimpleBbsDao implements ISimpleBbsDao{
	
	@Autowired  //JdbcTemplate 변수를 자동 주입으로 만든다.
	JdbcTemplate template; 

	@Override
	public List<SimpleBbsDto> listDao() {
		System.out.println("listDao()");
		
		String query = "select * from simple_bbs order by id desc";
		List<SimpleBbsDto> dtos = template.query(query,
				new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		//쿼리문의 결과가 하나 이상 즉 여러개가 나오는 SQL문을 처리하기위해서는 
		//JdbcTemplate의 query 메서드를 사용한다.
		return dtos;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("viewDao()");
		
		String query = "select * from simple_bbs where id ="+id; //변수를 이용해서 SQL문을 완성 가능하고
		SimpleBbsDto dto = template.queryForObject(query,
				new BeanPropertyRowMapper<SimpleBbsDto>(SimpleBbsDto.class));
		//SQL의 insert, delte, update 문은 JdbcTemplate의 update 메서드를 사용한다.
		
		return dto;
	}

	@Override
	public int writeDao(String writer, String title, String content) {
		System.out.println("writeDao()");
		
		String query = "insert into simple_bbs(writer, title, content) "+
						" values (?, ?, ?)";
		
		return template.update(query, writer, title, content); //메서드에 값을 파라미터로 넘길 수도 있다.
		//update 메서드의 첫번째 파라미터는 SQL문이고, 두 번째 파라미터는 SQL문 안의 ?에 순서대로 하나씩
		//대응해서 값을 입력한다.
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("deleteDao()");
		
		String query ="delete from simple_bbs where id = ?";
		return template.update(query, Integer.parseInt(id));
		//SQL의 insert, delte, update 문은 JdbcTemplate의 update 메서드를 사용한다.
	}
	
}



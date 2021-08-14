package com.study.springboot.jdbc;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMyUserDao {
	List<MyUserDTO> list();
}

//@Mapper 어노테이션은 다음 인터페이스의 구현을 XML로 한다는 의미이다.
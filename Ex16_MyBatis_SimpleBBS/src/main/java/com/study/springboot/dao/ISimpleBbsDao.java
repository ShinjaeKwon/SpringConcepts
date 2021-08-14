package com.study.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {

	public List<SimpleBbsDto> listDao(); //리스트를 보기 위한 select 
	public SimpleBbsDto viewDao(String id); //개별 뷰 보기 위한 select
	public int writeDao(String writer, String title, String content); //글 작성 insert
	public int deleteDao(String id); //글 삭제 delete
}

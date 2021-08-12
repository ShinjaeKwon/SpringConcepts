package com.study.springboot;

import java.util.List;

import com.study.springboot.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
	
	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDao(String writer, String title, String content);
	public int deleteDao(String id);
}

//listDao :리스트 보기를 위한 select 메서드 
//viewDao : 개별 뷰 보기를 위한 select 메서드
//writeDao : 글 작성을 위한 insert 메서드
//deleteDao : 글 삭젤ㄹ 위한 delete 메서드
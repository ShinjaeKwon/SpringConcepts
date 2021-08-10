package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ContentDto.class.isAssignableFrom(arg0);  //검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ContentDto dto = (ContentDto)obj;
		
//		String sWriter = dto.getWriter();
//		if(sWriter == null || sWriter.trim().isEmpty()) {
//			System.out.println("Writer is null or Empty");
//			errors.rejectValue("writer", "trouble");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer is empty");
		String sWriter = dto.getWriter();
		if(sWriter.length() < 3) {
			errors.rejectValue("writer", "writer is too short");
		}
		//위에서의 반복 작업을 스프링에서 제공하는 유틸 메서드를 사용하여 편리하게 한다.
		
//		String sContent = dto.getContent();
//		if(sContent == null || sContent.trim().isEmpty()) {
//			System.out.println("Content is null or empty");
//			errors.rejectValue("content", "trouble");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is empty.");
		
	}
	
	
}

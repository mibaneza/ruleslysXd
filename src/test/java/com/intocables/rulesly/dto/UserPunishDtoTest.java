package com.intocables.rulesly.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UserPunishDtoTest {
	final String added = "added";
	final String addedvalue = "2015/12/06 17:03:00";
	final String typevalue = "BANNED";
	final String type = "type";
	final String reasonvalue = "Chinese (steam:11000010a6b022d) durante un tiempo indefinido por zerkiN. Razón: PC (apelar en discord).";
	final String reason = "reason";
	final UserPunishDto userPunishDto = new UserPunishDto();
	String result;
	
	@Test
	void setAddedTest() throws  NoSuchFieldException, IllegalAccessException {
		userPunishDto.setAdded(addedvalue);

		final Field field = userPunishDto.getClass().getDeclaredField(added);
		field.setAccessible(true);
			
		assertEquals(field.get(userPunishDto), addedvalue);
		
	}
	@Test
	void getAddedTest() throws  NoSuchFieldException, IllegalAccessException {

		final Field field = userPunishDto.getClass().getDeclaredField(added);
		
		field.setAccessible(true);
		field.set(userPunishDto, addedvalue);
		
		 result = userPunishDto.getAdded();
		
		assertEquals(result,addedvalue);
	}
	@Test
	void setTypeTest() throws NoSuchFieldException, IllegalAccessException {

		
		userPunishDto.setType(typevalue);
		final Field field = userPunishDto.getClass().getDeclaredField(type);
		field.setAccessible(true);
		assertEquals(field.get(userPunishDto),typevalue);
	}
	
	@Test
	void getTypeTest() throws NoSuchFieldException, IllegalAccessException {
		final Field field = userPunishDto.getClass().getDeclaredField(type);
		
		field.setAccessible(true);
		field.set(userPunishDto, typevalue);
		result = userPunishDto.getType();
		assertEquals(result,typevalue);

	}
	@Test
	void setReasonTest() throws NoSuchFieldException, IllegalAccessException {
		userPunishDto.setReason(reasonvalue);
		final Field field = userPunishDto.getClass().getDeclaredField(reason);
		field.setAccessible(true);
		assertEquals(field.get(userPunishDto),reasonvalue);
	}

	@Test
	void getReasonTest() throws NoSuchFieldException, IllegalAccessException {
		final Field field = userPunishDto.getClass().getDeclaredField(reason);
		
		field.setAccessible(true);
		field.set(userPunishDto, reasonvalue);
		result = userPunishDto.getReason();
		assertEquals(result, reasonvalue);
	}

}

package com.intocables.rulesly.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.service.dto.UserPunishDTO;



@SpringBootTest
class UserPunishDtoTest {
	final String added = "added";
	final String addedvalue = "2015/12/06 17:03:00";
	final String typevalue = "BANNED";
	final String type = "type";
	final String reasonvalue = "Chinese (steam:11000010a6b022d) durante un tiempo indefinido por zerkiN. Razón: PC (apelar en discord).";
	final String reason = "reason";
	final UserPunishDTO userPunishDTO = new UserPunishDTO();
	String result;
	
	@Test
	void setAddedTest() throws  NoSuchFieldException, IllegalAccessException {
		userPunishDTO.setAdded(addedvalue);

		final Field field = userPunishDTO.getClass().getDeclaredField(added);
		field.setAccessible(true);
			
		assertEquals(field.get(userPunishDTO), addedvalue);
		
	}
	@Test
	void getAddedTest() throws  NoSuchFieldException, IllegalAccessException {

		final Field field = userPunishDTO.getClass().getDeclaredField(added);
		
		field.setAccessible(true);
		field.set(userPunishDTO, addedvalue);
		
		 result = userPunishDTO.getAdded();
		
		assertEquals(result,addedvalue);
	}
	@Test
	void setTypeTest() throws NoSuchFieldException, IllegalAccessException {

		
		userPunishDTO.setType(typevalue);
		final Field field = userPunishDTO.getClass().getDeclaredField(type);
		field.setAccessible(true);
		assertEquals(field.get(userPunishDTO),typevalue);
	}
	
	@Test
	void getTypeTest() throws NoSuchFieldException, IllegalAccessException {
		final Field field = userPunishDTO.getClass().getDeclaredField(type);
		
		field.setAccessible(true);
		field.set(userPunishDTO, typevalue);
		result = userPunishDTO.getType();
		assertEquals(result,typevalue);

	}
	@Test
	void setReasonTest() throws NoSuchFieldException, IllegalAccessException {
		userPunishDTO.setReason(reasonvalue);
		final Field field = userPunishDTO.getClass().getDeclaredField(reason);
		field.setAccessible(true);
		assertEquals(field.get(userPunishDTO),reasonvalue);
	}

	@Test
	void getReasonTest() throws NoSuchFieldException, IllegalAccessException {
		final Field field = userPunishDTO.getClass().getDeclaredField(reason);
		
		field.setAccessible(true);
		field.set(userPunishDTO, reasonvalue);
		result = userPunishDTO.getReason();
		assertEquals(result, reasonvalue);
	}

}

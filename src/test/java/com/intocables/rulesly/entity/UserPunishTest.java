package com.intocables.rulesly.entity;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserPunishTest {
	
	final String formatadded = "yyyy-MM-dd HH:mm:ss";
	final String added = "added";
	final String addedvalue = "2015-12-06 17:03:00";
	final String typevalue = "BANNED";
	final String type = "type";
	final String reasonvalue = "Chinese (steam:11000010a6b022d) durante un tiempo indefinido por zerkiN. Razón: PC (apelar en discord).";
	final String reason = "reason";
	String result;
	
	@Test
	void setAddedTest() throws  NoSuchFieldException, IllegalAccessException, ParseException {
	final UserPunishEntity userPunishEntity = new UserPunishEntity();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatadded);
		Date fecha = dateFormat.parse(addedvalue);
		userPunishEntity.setAdded(fecha);

		final Field field = userPunishEntity.getClass().getDeclaredField(added);
		field.setAccessible(true);
			
		assertEquals(field.get(userPunishEntity), fecha);
		
	}
	@Test
	void getAddedTest() throws  NoSuchFieldException, IllegalAccessException, ParseException {
		final UserPunishEntity userPunishEntity = new UserPunishEntity();
		final Field field = userPunishEntity.getClass().getDeclaredField(added);
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatadded);
		Date fecha = dateFormat.parse(addedvalue);
		field.setAccessible(true);
		field.set(userPunishEntity, fecha);
		
		final Date results = userPunishEntity.getAdded();
		
		assertEquals(results,fecha);
	}
	@Test
	void setTypeTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunishEntity userPunishEntity = new UserPunishEntity();
		
		userPunishEntity.setType(typevalue);
		final Field field = userPunishEntity.getClass().getDeclaredField(type);
		field.setAccessible(true);
		assertEquals(field.get(userPunishEntity),typevalue);
	}
	
	@Test
	void getTypeTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunishEntity userPunishEntity = new UserPunishEntity();
		final Field field = userPunishEntity.getClass().getDeclaredField(type);
		
		field.setAccessible(true);
		field.set(userPunishEntity, typevalue);
		result = userPunishEntity.getType();
		assertEquals(result,typevalue);

	}
	@Test
	void setReasonTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunishEntity userPunishEntity = new UserPunishEntity();
		userPunishEntity.setReason(reasonvalue);
		final Field field = userPunishEntity.getClass().getDeclaredField(reason);
		field.setAccessible(true);
		assertEquals(field.get(userPunishEntity),reasonvalue);
	}

	@Test
	void getReasonTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunishEntity userPunishEntity = new UserPunishEntity();
		final Field field = userPunishEntity.getClass().getDeclaredField(reason);
		
		field.setAccessible(true);
		field.set(userPunishEntity, reasonvalue);
		result = userPunishEntity.getReason();
		assertEquals(result, reasonvalue);
	}

}

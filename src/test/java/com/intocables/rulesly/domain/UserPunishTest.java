package com.intocables.rulesly.domain;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.domain.UserPunish;

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
	final UserPunish userPunish = new UserPunish();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatadded);
		Date fecha = dateFormat.parse(addedvalue);
		userPunish.setAdded(fecha);

		final Field field = userPunish.getClass().getDeclaredField(added);
		field.setAccessible(true);
			
		assertEquals(field.get(userPunish), fecha);
		
	}
	@Test
	void getAddedTest() throws  NoSuchFieldException, IllegalAccessException, ParseException {
		final UserPunish userPunish = new UserPunish();
		final Field field = userPunish.getClass().getDeclaredField(added);
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatadded);
		Date fecha = dateFormat.parse(addedvalue);
		field.setAccessible(true);
		field.set(userPunish, fecha);
		
		final Date results = userPunish.getAdded();
		
		assertEquals(results,fecha);
	}
	@Test
	void setTypeTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunish userPunish = new UserPunish();
		
		userPunish.setType(typevalue);
		final Field field = userPunish.getClass().getDeclaredField(type);
		field.setAccessible(true);
		assertEquals(field.get(userPunish),typevalue);
	}
	
	@Test
	void getTypeTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunish userPunish = new UserPunish();
		final Field field = userPunish.getClass().getDeclaredField(type);
		
		field.setAccessible(true);
		field.set(userPunish, typevalue);
		result = userPunish.getType();
		assertEquals(result,typevalue);

	}
	@Test
	void setReasonTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunish userPunish = new UserPunish();
		userPunish.setReason(reasonvalue);
		final Field field = userPunish.getClass().getDeclaredField(reason);
		field.setAccessible(true);
		assertEquals(field.get(userPunish),reasonvalue);
	}

	@Test
	void getReasonTest() throws NoSuchFieldException, IllegalAccessException {
		final UserPunish userPunish = new UserPunish();
		final Field field = userPunish.getClass().getDeclaredField(reason);
		
		field.setAccessible(true);
		field.set(userPunish, reasonvalue);
		result = userPunish.getReason();
		assertEquals(result, reasonvalue);
	}

}

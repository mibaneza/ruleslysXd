package com.intocables.rulesly.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.service.dto.ErrorDTO;

@SpringBootTest
class ErrorDtoTest {
	final String name = "name";
	final String namevalue = "error";
	final String values = "value";
	final String valueval= "TestError";
	String result;
	
	@Test
	void setNameTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDTO errorDTO = new ErrorDTO();
		
		errorDTO.setName(namevalue);
		final Field field = errorDTO.getClass().getDeclaredField(name);
		field.setAccessible(true);
		assertEquals(field.get(errorDTO),namevalue);
		
	}
	
	@Test
	void getNameTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDTO errorDTO = new ErrorDTO();
		final Field field = errorDTO.getClass().getDeclaredField(name);
		
		field.setAccessible(true);
		field.set(errorDTO, namevalue);
		result = errorDTO.getName();
		assertEquals(result, namevalue);
	
	}
	
	@Test
	void setValueTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setValue(valueval);
		final Field field = errorDTO.getClass().getDeclaredField(values);
		field.setAccessible(true);
		assertEquals(field.get(errorDTO),valueval);
	
	}

	@Test
	void getValueTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDTO errorDTO = new ErrorDTO();
		final Field field = errorDTO.getClass().getDeclaredField("value");

		field.setAccessible(true);
		field.set(errorDTO, valueval);
		
		result = errorDTO.getValue();
		
		
		assertEquals(result, valueval);

	}
}

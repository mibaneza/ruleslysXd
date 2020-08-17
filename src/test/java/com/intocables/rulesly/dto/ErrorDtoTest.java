package com.intocables.rulesly.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ErrorDtoTest {
	final String name = "name";
	final String namevalue = "error";
	final String values = "value";
	final String valueval= "TestError";
	String result;
	
	@Test
	void setNameTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDto errorDto = new ErrorDto();
		
		errorDto.setName(namevalue);
		final Field field = errorDto.getClass().getDeclaredField(name);
		field.setAccessible(true);
		assertEquals(field.get(errorDto),namevalue);
		
	}
	
	@Test
	void getNameTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDto errorDto = new ErrorDto();
		final Field field = errorDto.getClass().getDeclaredField(name);
		
		field.setAccessible(true);
		field.set(errorDto, namevalue);
		result = errorDto.getName();
		assertEquals(result, namevalue);
	
	}
	
	@Test
	void setValueTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDto errorDto = new ErrorDto();
		errorDto.setValue(valueval);
		final Field field = errorDto.getClass().getDeclaredField(values);
		field.setAccessible(true);
		assertEquals(field.get(errorDto),valueval);
	
	}

	@Test
	void getValueTest() throws  NoSuchFieldException, IllegalAccessException{
		final ErrorDto errorDto = new ErrorDto();
		final Field field = errorDto.getClass().getDeclaredField("value");

		field.setAccessible(true);
		field.set(errorDto, valueval);
		
		result = errorDto.getValue();
		
		
		assertEquals(result, valueval);

	}
}

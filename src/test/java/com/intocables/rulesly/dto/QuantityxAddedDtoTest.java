package com.intocables.rulesly.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuantityxAddedDtoTest {

	final String datevalue = "2015-12-06 17:03:00";
	final String date = "date";
	final String quantity = "quantity";
	final int quantityvalue = 50;
	final QuantityxAddedDto quantityxAddedDto = new QuantityxAddedDto();
	int results;
	String result;
	
	@Test
	void getQuantity() throws  NoSuchFieldException, IllegalAccessException{
		final Field field = quantityxAddedDto.getClass().getDeclaredField(quantity);
		
		field.setAccessible(true);
		field.set(quantityxAddedDto, quantityvalue);
		results = quantityxAddedDto.getQuantity();
		assertEquals(results, quantityvalue);
	}
	
	@Test
	void setQuantity() throws  NoSuchFieldException, IllegalAccessException{
		quantityxAddedDto.setQuantity(quantityvalue);
		final Field field = quantityxAddedDto.getClass().getDeclaredField(quantity);
		field.setAccessible(true);
		assertEquals(field.get(quantityxAddedDto),quantityvalue);
	}
	
	@Test
	void getDate() throws  NoSuchFieldException, IllegalAccessException{
		final Field field = quantityxAddedDto.getClass().getDeclaredField(date);
		
		field.setAccessible(true);
		field.set(quantityxAddedDto, datevalue);
		 result = quantityxAddedDto.getDate();
		assertEquals(result, datevalue);
	}
	
	@Test
	void setDate() throws  NoSuchFieldException, IllegalAccessException{
		quantityxAddedDto.setDate(datevalue);
		final Field field = quantityxAddedDto.getClass().getDeclaredField(date);
		field.setAccessible(true);
		assertEquals(field.get(quantityxAddedDto),datevalue);
	}

}

package com.intocables.rulesly.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.service.dto.QuantityxAddedDTO;

@SpringBootTest
class QuantityxAddedDtoTest {

	final String datevalue = "2015-12-06 17:03:00";
	final String date = "date";
	final String quantity = "quantity";
	final int quantityvalue = 50;
	final QuantityxAddedDTO quantityxAddedDTO = new QuantityxAddedDTO();
	int results;
	String result;
	
	@Test
	void getQuantity() throws  NoSuchFieldException, IllegalAccessException{
		final Field field = quantityxAddedDTO.getClass().getDeclaredField(quantity);
		
		field.setAccessible(true);
		field.set(quantityxAddedDTO, quantityvalue);
		results = quantityxAddedDTO.getQuantity();
		assertEquals(results, quantityvalue);
	}
	
	@Test
	void setQuantity() throws  NoSuchFieldException, IllegalAccessException{
		quantityxAddedDTO.setQuantity(quantityvalue);
		final Field field = quantityxAddedDTO.getClass().getDeclaredField(quantity);
		field.setAccessible(true);
		assertEquals(field.get(quantityxAddedDTO),quantityvalue);
	}
	
	@Test
	void getDate() throws  NoSuchFieldException, IllegalAccessException{
		final Field field = quantityxAddedDTO.getClass().getDeclaredField(date);
		
		field.setAccessible(true);
		field.set(quantityxAddedDTO, datevalue);
		 result = quantityxAddedDTO.getDate();
		assertEquals(result, datevalue);
	}
	
	@Test
	void setDate() throws  NoSuchFieldException, IllegalAccessException{
		quantityxAddedDTO.setDate(datevalue);
		final Field field = quantityxAddedDTO.getClass().getDeclaredField(date);
		field.setAccessible(true);
		assertEquals(field.get(quantityxAddedDTO),datevalue);
	}

}

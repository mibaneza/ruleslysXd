package com.intocables.rulesly.service.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.dto.ErrorDto;

@SpringBootTest
class RuleslyExceptionTest {
	
	@Test
	void getCode() throws NoSuchFieldException, IllegalAccessException {
	final RuleslyException ruleslyException = new RuleslyException(null, 0, null);
	final Field field = ruleslyException.getClass().getDeclaredField("code");
	
	field.setAccessible(true);
	
	field.set(ruleslyException, "505");
	String result = ruleslyException.getCode();
	assertEquals("505", result);
	}

	@Test
	void getResponseCode() throws NoSuchFieldException, IllegalAccessException {
		final RuleslyException ruleslyException = new RuleslyException(null, 0, null,null);
		final Field field = ruleslyException.getClass().getDeclaredField("responseCode");
		
		field.setAccessible(true);
		
		field.set(ruleslyException, 505);
		int result = ruleslyException.getResponseCode();
		assertEquals(505, result);
		
	}

	@Test
	void getErrorList() throws NoSuchFieldException, IllegalAccessException {
		final RuleslyException ruleslyException = new RuleslyException(null, 0, null,null);
		final Field field = ruleslyException.getClass().getDeclaredField("errorList");
		final List<ErrorDto> errorLists = new ArrayList<>();
		errorLists.add(new ErrorDto("ERROR", "404"));
		
		field.setAccessible(true);
		
		field.set(ruleslyException, errorLists);
		List<ErrorDto> resultList = ruleslyException.getErrorList();
		assertEquals(1, resultList.size());
		assertEquals(errorLists, resultList);
	}
}

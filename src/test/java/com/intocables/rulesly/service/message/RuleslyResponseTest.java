package com.intocables.rulesly.service.message;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.dto.ErrorDto;


@SpringBootTest
class RuleslyResponseTest {
	String result;

	@Test
	void setStatusTest() throws NoSuchFieldException, IllegalAccessException {
		final RuleslyResponse<?> response = new RuleslyResponse(null,null,null);
		response.setStatus("Succes");
		final Field field = response.getClass().getDeclaredField("status");
		field.setAccessible(true);
		assertEquals("Succes", field.get(response));
	}

	@Test
	void setCodeTest() throws NoSuchFieldException, IllegalAccessException {
		final RuleslyResponse<?> response = new RuleslyResponse(null,null,null);
		response.setCode("200 OK");
		final Field field = response.getClass().getDeclaredField("code");
		field.setAccessible(true);
		assertEquals("200 OK", field.get(response));
		
	}

	@Test
	void setMessageTest() throws NoSuchFieldException, IllegalAccessException {
		final RuleslyResponse<?> response = new RuleslyResponse(null,null,null);
		response.setMessage("OK");
		final Field field = response.getClass().getDeclaredField("message");
		field.setAccessible(true);
		assertEquals("OK", field.get(response));
	}

	@Test
	void setDataTest() throws NoSuchFieldException, IllegalAccessException {
		final RuleslyResponse<List<ErrorDto>> response = new RuleslyResponse<List<ErrorDto>>(null,null,null,null);
		final List<ErrorDto> errorLists = new ArrayList<>();
		errorLists.add(new ErrorDto("ERROR", "404"));
		
		response.setData(errorLists);
		final Field field = response.getClass().getDeclaredField("data");
		field.setAccessible(true);
		assertEquals(field.get(response),errorLists);
		assertEquals(1, errorLists.size());

	}
}

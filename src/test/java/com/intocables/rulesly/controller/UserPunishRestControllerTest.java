package com.intocables.rulesly.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.service.UserPunishService;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.message.RuleslyResponse;

@SpringBootTest
class UserPunishRestControllerTest {
	private static final String SUCCES_STATUS ="Succes";
	private static final String SUCCES_CODE ="200 OK";
	private static final String OK ="OK";
	private static final List<UserPunishDto> USERPUNISHDTO = new ArrayList<>();
	private static final List<QuantityxAddedDto> QUANTITYADDEDDTO = new ArrayList<>();
	
	@Mock
	UserPunishService userPunishService;
	
	@InjectMocks
	UserPunishRestController userPunishRestController;
	
	@BeforeEach
	void init() throws RuleslyException{
		MockitoAnnotations.initMocks(this);
		Mockito.when(userPunishService.findSQLAverage()).thenReturn(85);
	}
	
	@Test
	void readGetAverageTest() throws RuleslyException{
		final RuleslyResponse<Integer> response = userPunishRestController.readGetAverage();
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), (int) 85);
	}
	@Test
	void readGetUserPunishTest() throws RuleslyException{
		final RuleslyResponse<List<UserPunishDto>> response = userPunishRestController.readGetUserPunish();
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), USERPUNISHDTO);
	}
	@Test
	void readGetQuantityPunishTest() throws RuleslyException{
		final RuleslyResponse<List<QuantityxAddedDto>> response = userPunishRestController.readGetQuantityPunish();
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), QUANTITYADDEDDTO);
	}
}

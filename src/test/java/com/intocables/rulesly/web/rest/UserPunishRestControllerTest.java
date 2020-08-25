package com.intocables.rulesly.web.rest;

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

import com.intocables.rulesly.service.UserPunishService;
import com.intocables.rulesly.service.dto.QuantityxAddedDTO;
import com.intocables.rulesly.service.dto.UserPunishDTO;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.message.RuleslyResponse;
import com.intocables.rulesly.web.rest.UserPunishResource;

@SpringBootTest
class UserPunishRestControllerTest {
	private static final String SUCCES_STATUS ="Succes";
	private static final String SUCCES_CODE ="200 OK";
	private static final String OK ="OK";
	private static final List<UserPunishDTO> USERPUNISHDTO = new ArrayList<>();
	private static final List<QuantityxAddedDTO> QUANTITYADDEDDTO = new ArrayList<>();
	
	@Mock
	UserPunishService userPunishService;
	
	@InjectMocks
	UserPunishResource userPunishResource;
	
	@BeforeEach
	public void init() throws RuleslyException{
		MockitoAnnotations.initMocks(this);
		Mockito.when(userPunishService.findSQLAverage()).thenReturn(85);
	}
	
	@Test
	void readGetAverageTest() throws RuleslyException{
		final RuleslyResponse<Integer> response = userPunishResource.readGetAverage();
		assertEquals(SUCCES_STATUS, response.getStatus());
		assertEquals(SUCCES_CODE, response.getCode());
		assertEquals(OK, response.getMessage());
		assertEquals((int) 85,response.getData());
	}
	@Test
	void readGetUserPunishTest() throws RuleslyException{
		final RuleslyResponse<List<UserPunishDTO>> response = userPunishResource.readGetUserPunish();
		assertEquals(SUCCES_STATUS, response.getStatus());
		assertEquals(SUCCES_CODE, response.getCode());
		assertEquals(OK, response.getMessage());
		assertEquals(USERPUNISHDTO,response.getData());
	}
	@Test
	void readGetQuantityPunishTest() throws RuleslyException{
		final RuleslyResponse<List<QuantityxAddedDTO>> response = userPunishResource.readGetQuantityPunish();
		assertEquals(SUCCES_STATUS, response.getStatus());
		assertEquals(SUCCES_CODE, response.getCode());
		assertEquals(OK, response.getMessage());
		assertEquals(QUANTITYADDEDDTO, response.getData());
	}
}

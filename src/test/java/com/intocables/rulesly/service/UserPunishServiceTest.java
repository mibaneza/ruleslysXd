package com.intocables.rulesly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.exception.RuleslyException;

@SpringBootTest
class UserPunishServiceTest {
	
	@Mock
	IUserPunishRepository userPunhisRepository;
	
	@InjectMocks
	UserPunishService userPunishService;
	
	BigInteger integar;
	
	
	
	@BeforeEach
	public void init() throws RuleslyException{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findSQLAverageTest()throws RuleslyException{
		 integar = new BigInteger("1800");
		Mockito.when(userPunhisRepository.findSQLByQuantity()).thenReturn(integar);
		userPunishService.findSQLAverage();
	}
	@Test
	public void findSQLAverageTestError()throws RuleslyException{
		Mockito.when(userPunhisRepository.findSQLByQuantity()).thenReturn(new BigInteger("0"));

		Assertions.assertThrows(NumberFormatException.class, () -> {
			integar = new BigInteger("");
		    });
		userPunishService.findSQLAverage();
	
		
	}
}

package com.intocables.rulesly.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date; 
import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@SpringBootTest
class UserPunishServiceTest {
	
	private static final List<UserPunishDto> USERPUNISHDTO = new ArrayList<>();
	private static final List<QuantityxAddedDto> QUANTITYADDEDDTO = new ArrayList<>();
    
	
	@Mock
	IUserPunishRepository userPunhisRepository;
	
	@InjectMocks
	UserPunishService userPunishService;
	
	BigInteger integar;
	
	@BeforeEach
	void init() throws RuleslyException{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void findAllUserPunishTest() throws RuleslyException{
		   Date result = null;
		    try{
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        result  = dateFormat.parse("2015-12-06 17:03:00");
		    }

		    catch(ParseException e){
		        e.printStackTrace();

		    }
		    System.out.print(result);
		 List<UserPunishEntity> userpunishlist = new ArrayList<>();
		userpunishlist.add( new UserPunishEntity(result,"awdawd","awdawdwadawd"));

		Mockito.when(userPunhisRepository.findSqlAll()).thenReturn(userpunishlist);
		 List<UserPunishDto> userpunishdto = userPunishService.findAllUserPunish();
		assertNotNull(userpunishdto);
		assertFalse(userpunishdto.isEmpty());
		assertEquals(0,userpunishdto.size());
		
		
			
	}
	
	@Test
	void findSQLAverageTest() throws RuleslyException{
		 integar = new BigInteger("1800");
		Mockito.when(userPunhisRepository.findSQLByQuantity()).thenReturn(integar);
		userPunishService.findSQLAverage();
	}
	
	@Test
	void findSQLAverageTestError() throws RuleslyException{
		Mockito.when(userPunhisRepository.findSQLByQuantity()).thenReturn(new BigInteger("0"));

		Assertions.assertThrows(NumberFormatException.class, () -> {
			integar = new BigInteger("");
		    });
		userPunishService.findSQLAverage();	
	}
	
}

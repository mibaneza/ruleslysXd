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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date; 
import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.mapper.UserPunishMapper;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@SpringBootTest
class UserPunishServiceTest {
	
	private static final List<UserPunishDto> USERPUNISHDTO = new ArrayList<>();
	private static final List<QuantityxAddedDto> QUANTITYADDEDDTO = new ArrayList<>();
    
	
	@Mock
	IUserPunishRepository userPunhisRepository;
	
	@InjectMocks
	UserPunishService userPunishService;
	
	@Mock
	UserPunishMapper userPunishMapper;
	
	BigInteger integar;
	
	@BeforeEach
	void init() throws RuleslyException{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void findAllUserPunishTest() throws RuleslyException, ParseException{
		   Date result = null;
		   Date resulta = null;
		   Date resultad = null;
		   String dateFormats = null;
		   List<UserPunishDto> userpunishdto = new ArrayList<>();
		   List<UserPunishDto> userpunishdtos = new ArrayList<>();
		
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		       
		        result  = dateFormat.parse("2015-12-06 17:03:00");
		        resulta  = dateFormat.parse("2015-12-06 17:03:00");
		        
		         dateFormats = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(resulta);
	
	
		 List<UserPunishEntity> userpunishlist = new ArrayList<>() ;
		userpunishlist.add( new UserPunishEntity(result,"ADVERT","Monchin (steam:110000112c1afbc) fue"));
		userpunishlist.add( new UserPunishEntity(resulta,"BANNED","LUZBELITOO (steam:1100001063de14f"));
		
		userpunishdtos.add( new UserPunishDto("2016-12-06 17:03:00","ADVERT","Monchin (steam:110000112c1afbc) fue"));
		userpunishdtos.add( new UserPunishDto("2015-12-06 17:03:00","BANNED","LUZBELITOO (steam:1100001063de14f"));
		Mockito.when(userPunhisRepository.findSqlAll()).thenReturn(userpunishlist);
		Mockito.when(userPunishMapper.mapper(userpunishlist)).thenReturn(userpunishdtos);;
		
		userpunishdto = userPunishService.findAllUserPunish();

		 System.out.println(userpunishdto.size());
		assertNotNull(userpunishdto);
		assertFalse(userpunishdto.isEmpty());
		assertEquals(2,userpunishdto.size());
		
		
			
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

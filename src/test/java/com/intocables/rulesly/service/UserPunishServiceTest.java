package com.intocables.rulesly.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
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

import com.intocables.rulesly.domain.UserPunish;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.dto.QuantityxAddedDTO;
import com.intocables.rulesly.service.dto.UserPunishDTO;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.mapper.QuantityPunishMapper;
import com.intocables.rulesly.service.mapper.UserPunishMapper;


@SpringBootTest
class UserPunishServiceTest {

	@Mock
	IUserPunishRepository userPunhisRepository;

	@InjectMocks
	UserPunishService userPunishService;

	@Mock
	UserPunishMapper userPunishMapper;
	
	@Mock
	QuantityPunishMapper quantityPunishMapper;
	
	BigInteger integar;
	
	UserPunish userPunish;

	@BeforeEach
	void init() throws RuleslyException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void findAllUserPunishTest() throws RuleslyException, ParseException {
		Date result = null;
		Date resulta = null;
		List<UserPunishDTO> userpunishdto = new ArrayList<>();
		List<UserPunishDTO> userpunishdtos = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		result = dateFormat.parse("2015-12-06 17:03:00");
		resulta = dateFormat.parse("2015-12-06 17:03:00");

		
		List<UserPunish> userpunishlist = new ArrayList<>();
		userpunishlist.add(new UserPunish(result, "ADVERT", "Monchin (steam:110000112c1afbc) fue"));
		userpunishlist.add(new UserPunish(resulta, "BANNED", "LUZBELITOO (steam:1100001063de14f"));

		userpunishdtos.add(new UserPunishDTO("2016-12-06 17:03:00", "ADVERT", "Monchin (steam:110000112c1afbc) fue"));
		userpunishdtos.add(new UserPunishDTO("2015-12-06 17:03:00", "BANNED", "LUZBELITOO (steam:1100001063de14f"));
		Mockito.when(userPunhisRepository.findSqlAll()).thenReturn(Optional.of(userpunishlist));
		Mockito.when(userPunishMapper.mapper(userpunishlist)).thenReturn(userpunishdtos);
		

		userpunishdto = userPunishService.findAllUserPunish();

		assertNotNull(userpunishdto);
		assertFalse(userpunishdto.isEmpty());
		assertEquals(2, userpunishdto.size());

	}

/*	@Test
	void findAllUserPunishTestError() throws RuleslyException {
		List<UserPunishDto> userpunishdtos = new ArrayList<>();
		List<UserPunishEntity> userpunishlist = new ArrayList<>();
		Mockito.when(userPunhisRepository.findSqlAll()).thenReturn(Optional.empty());
		Mockito.when(userPunishMapper.mapper(null)).thenReturn(userpunishdtos);
		
		Assertions.assertThrows(NotFountException.class, () -> {
	
		});
		try {
		userPunishService.findAllUserPunish();
		}catch(Exception e) {
			System.out.println(e);
		}

	}*/
	@Test
	void findSQLByQuantityAndAddedsTest() throws RuleslyException {
		List<Object[]> objectAnom = new ArrayList<>();		
		List<QuantityxAddedDTO> quantityxAddedDTO = new ArrayList<>();
		List<QuantityxAddedDTO> quantityxAddedDTOs = new ArrayList<>();
		Object[] e = {new BigInteger("25"),"2015-12-06"} ;
		Object[] ei = {new BigInteger("26"),"2015-13-06"} ;
		objectAnom.add(e);
		objectAnom.add(ei);
		quantityxAddedDTO.add(new QuantityxAddedDTO(25,"2015-12-06"));
		quantityxAddedDTO.add(new QuantityxAddedDTO(26,"2015-13-06"));
		Mockito.when(userPunhisRepository.findSQLByQuantityAndAddeds()).thenReturn(Optional.of(objectAnom));
		Mockito.when(quantityPunishMapper.mapper(objectAnom)).thenReturn(quantityxAddedDTO);
		
		quantityxAddedDTOs = userPunishService.findSQLByQuantityAndAddeds();

		assertNotNull(quantityxAddedDTOs);
		assertFalse(quantityxAddedDTOs.isEmpty());
		assertEquals(2, quantityxAddedDTOs.size());
		
	}
	
	@Test
	void findSQLAverageTest() throws RuleslyException {
		integar = new BigInteger("1800");
		Mockito.when(userPunhisRepository.findSQLByQuantity()).thenReturn(Optional.of(integar));
		int average = userPunishService.findSQLAverage();
		assertEquals(20, average);
	}
	
	@Test
	void findSQLAverageTestError() throws RuleslyException{
		Mockito.when(userPunhisRepository.findSQLByQuantity()).thenReturn(Optional.ofNullable(new BigInteger("0")));

		Assertions.assertThrows(NumberFormatException.class, () -> {
			integar = new BigInteger("");
		});
		userPunishService.findSQLAverage();

	}

}

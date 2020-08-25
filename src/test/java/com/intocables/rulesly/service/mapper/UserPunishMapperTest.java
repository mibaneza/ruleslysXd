package com.intocables.rulesly.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.domain.UserPunish;
import com.intocables.rulesly.service.dto.UserPunishDTO;


@SpringBootTest
class UserPunishMapperTest {
	@InjectMocks
	UserPunishMapper userPunishMapper;
	
	@Test
	void mapper() throws ParseException {
		Date result = null;
		List<UserPunish> userPunish = new ArrayList<>();
		List<UserPunishDTO> userPunishDTOs = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = dateFormat.parse("2015-12-06 17:03:00");
		
		userPunish.add(new UserPunish(result, "ADVERT", "Monchin (steam:110000112c1afbc) fue"));
		userPunishDTOs = userPunishMapper.mapper(userPunish);
		
		
		assertNotNull(userPunishDTOs);
		assertFalse(userPunishDTOs.isEmpty());
		assertEquals(1, userPunishDTOs.size());
	}

}

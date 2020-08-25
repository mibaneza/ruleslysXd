package com.intocables.rulesly.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.intocables.rulesly.service.dto.QuantityxAddedDTO;

@SpringBootTest
class QuantityPunishMapperTest {
	
	@InjectMocks
	QuantityPunishMapper quantityPunishMapper;
	
	@Test
	void mapper() {
		List<Object[]> objectAnom = new ArrayList<>();
		List<QuantityxAddedDTO> quantityxAddedDTOs = new ArrayList<>();
		Object[] e = {new BigInteger("25"),"2015-12-06"};
		objectAnom.add(e);
		quantityxAddedDTOs = quantityPunishMapper.mapper(objectAnom);
		
		assertNotNull(quantityxAddedDTOs);
		assertFalse(quantityxAddedDTOs.isEmpty());
		assertEquals(1, quantityxAddedDTOs.size());
	}

}

package com.intocables.rulesly.service.mapper;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.intocables.rulesly.dto.QuantityxAddedDto;

@Component
public class QuantityPunishMapper {
	public List<QuantityxAddedDto> mapper (List<Object[]>  quantityPunishEntitys){
		List<QuantityxAddedDto> quantityxAddedDtos = new ArrayList<>();
	for(Object[] obj : quantityPunishEntitys) {
		quantityxAddedDtos.add(new QuantityxAddedDto(((BigInteger) obj[0]).intValue(),(String) obj[1]));
	}	
		return quantityxAddedDtos;
	}

}

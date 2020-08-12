package com.intocables.rulesly.service.mapper;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

import com.intocables.rulesly.dto.QuantityxAddedDto;


public class QuantityPunishMapper {
	public static List<QuantityxAddedDto> mapper (List<Object[]>  _QuantityPunishEntitys){
		List<QuantityxAddedDto> _QuantityxAddedDtos = new ArrayList<QuantityxAddedDto>();
	for(Object[] obj : _QuantityPunishEntitys) {
		_QuantityxAddedDtos.add(new QuantityxAddedDto(((BigInteger) obj[0]).intValue(),(String) obj[1]));
	}	
		return _QuantityxAddedDtos;
	}

}

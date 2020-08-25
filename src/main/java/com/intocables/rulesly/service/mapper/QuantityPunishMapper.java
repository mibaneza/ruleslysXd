package com.intocables.rulesly.service.mapper;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.intocables.rulesly.service.dto.QuantityxAddedDTO;

@Component
public class QuantityPunishMapper {
	public List<QuantityxAddedDTO> mapper (List<Object[]>  quantityPunishEntitys){
		List<QuantityxAddedDTO> quantityxAddedDTOs = new ArrayList<>();
	for(Object[] obj : quantityPunishEntitys) {
		quantityxAddedDTOs.add(new QuantityxAddedDTO(((BigInteger) obj[0]).intValue(),(String) obj[1]));
	}	
		return quantityxAddedDTOs;
	}

}

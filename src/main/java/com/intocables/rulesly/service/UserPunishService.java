package com.intocables.rulesly.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intocables.rulesly.domain.UserPunish;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.mapper.QuantityPunishMapper;
import com.intocables.rulesly.service.mapper.UserPunishMapper;
import com.intocables.rulesly.service.dto.QuantityxAddedDTO;
import com.intocables.rulesly.service.dto.UserPunishDTO;
import com.intocables.rulesly.service.exception.NotFountException;
import com.intocables.rulesly.service.exception.RuleslyException;

@Service
public class UserPunishService {

	private static final String INTERNALERROR = "INTERNAL_SERVER_ERROR";
	private static final String SNOT404 = "SNOT-404-1";
	
	@Autowired
	UserPunishMapper userPunishMapper;
	
	@Autowired
	QuantityPunishMapper quantityPunishMapper;
	
	@Autowired
	IUserPunishRepository userPunhisRepository;
	
	@Transactional(readOnly=true)
	@Cacheable(value = "usersPunishCache")
	public List<UserPunishDTO> findAllUserPunish() throws RuleslyException{		
		List<UserPunish> userPunish;
		List<UserPunishDTO> userPunishDTO;
			 userPunish = userPunhisRepository.findSqlAll()
					 .orElseThrow(() -> new NotFountException(SNOT404, INTERNALERROR));	
		 userPunishDTO = userPunishMapper.mapper(userPunish);
		return userPunishDTO;
	}
	
	@Transactional(readOnly=true)
	@Cacheable(value = "quantityAndAddedsCache")
	public List<QuantityxAddedDTO> findSQLByQuantityAndAddeds() throws RuleslyException{		
		List<Object[]> objectAnom;
		List<QuantityxAddedDTO> quantityxAddedDTO;

		objectAnom = userPunhisRepository.findSQLByQuantityAndAddeds()
					 .orElseThrow(() -> new NotFountException(SNOT404, INTERNALERROR));	
			 quantityxAddedDTO = quantityPunishMapper.mapper(objectAnom);
			
		return quantityxAddedDTO;
	}
	
	@Transactional(readOnly=true)
	@Cacheable(value = "averageCache")
	public int findSQLAverage() throws RuleslyException{		
		BigInteger quantityxAddedDtos;
			 quantityxAddedDtos = userPunhisRepository.findSQLByQuantity()
					 .orElseThrow(() -> new NotFountException(SNOT404, INTERNALERROR));	 
		return quantityxAddedDtos.intValue()/90;
	}
}

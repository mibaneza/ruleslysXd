package com.intocables.rulesly.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.mapper.QuantityPunishMapper;
import com.intocables.rulesly.service.mapper.UserPunishMapper;

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
	public List<UserPunishDto> findAllUserPunish() throws RuleslyException{		
		List<UserPunishEntity> userPunishEntitys;
		List<UserPunishDto> userPunishDto;
			 userPunishEntitys = userPunhisRepository.findSqlAll()
					 .orElseThrow(() -> new NotFountException(SNOT404, INTERNALERROR));	
		 userPunishDto = userPunishMapper.mapper(userPunishEntitys);
		return userPunishDto;
	}
	
	@Transactional(readOnly=true)
	@Cacheable(value = "quantityAndAddedsCache")
	public List<QuantityxAddedDto> findSQLByQuantityAndAddeds() throws RuleslyException{		
		List<Object[]> objectAnom;
		List<QuantityxAddedDto> quantityxAddedDto;

		objectAnom = userPunhisRepository.findSQLByQuantityAndAddeds()
					 .orElseThrow(() -> new NotFountException(SNOT404, INTERNALERROR));	
			 quantityxAddedDto = quantityPunishMapper.mapper(objectAnom);
			
		return quantityxAddedDto;
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

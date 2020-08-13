package com.intocables.rulesly.service;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intocables.rulesly.dto.AverageDto;
import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.mapper.QuantityPunishMapper;
import com.intocables.rulesly.service.mapper.UserPunishMapper;

import  com.intocables.rulesly.service.exception.InternalServerErrorException;

@Service
public class UserPunishService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserPunishService.class);
	
	private static final String INTERNALERROR = "INTERNAL_SERVER_ERROR";
	
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
		try {
			 userPunishEntitys = userPunhisRepository.findSqlAll();
			 
		} catch (final Exception e) {
			LOGGER.error(INTERNALERROR);
			throw new InternalServerErrorException(INTERNALERROR, INTERNALERROR);
		}
		
				
		return userPunishMapper.mapper(userPunishEntitys);
	}
	@Transactional(readOnly=true)
	@Cacheable(value = "quantityAndAddedsCache")
	public List<QuantityxAddedDto> findSQLByQuantityAndAddeds() throws RuleslyException{		
		List<Object[]> quantityxAddedDtos;
		try {
			 quantityxAddedDtos = userPunhisRepository.findSQLByQuantityAndAddeds();
			 
		} catch (final Exception e) {
			LOGGER.error(INTERNALERROR);
			throw new InternalServerErrorException(INTERNALERROR, INTERNALERROR);
		}			
		return quantityPunishMapper.mapper(quantityxAddedDtos);
	}
	@Transactional(readOnly=true)
	@Cacheable(value = "averageCache")
	public AverageDto findSQLAverage() throws RuleslyException{		
		BigInteger quantityxAddedDtos;
		try {
			 quantityxAddedDtos = userPunhisRepository.findSQLByQuantity();
			 
		} catch (final Exception e) {
			LOGGER.error(INTERNALERROR);
			throw new InternalServerErrorException(INTERNALERROR, INTERNALERROR);
		}
		int days = quantityxAddedDtos.intValue()/90;
		AverageDto averageDto = new AverageDto(days);
	
		return averageDto;
	}
}

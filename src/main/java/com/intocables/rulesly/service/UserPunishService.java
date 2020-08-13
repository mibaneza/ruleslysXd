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
	
	@Autowired
	IUserPunishRepository userPunhisRepository;
	
	@Transactional(readOnly=true)
	@Cacheable(value = "usersPunishCache")
	public List<UserPunishDto> findAllUserPunish() throws RuleslyException{		
		List<UserPunishEntity> userPunishEntitys;
		try {
			 userPunishEntitys = userPunhisRepository.findSqlAll();
			 
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
				
		return UserPunishMapper.mapper(userPunishEntitys);
	}
	@Transactional(readOnly=true)
	@Cacheable(value = "quantityAndAddedsCache")
	public List<QuantityxAddedDto> findSQLByQuantityAndAddeds() throws RuleslyException{		
		List<Object[]> quantityxAddedDtos;
		try {
			 quantityxAddedDtos = userPunhisRepository.findSQLByQuantityAndAddeds();
			 
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
				
		return QuantityPunishMapper.mapper(quantityxAddedDtos);
	}
	@Transactional(readOnly=true)
	@Cacheable(value = "averageCache")
	public AverageDto findSQLAverage() throws RuleslyException{		
		BigInteger quantityxAddedDtos;
		try {
			 quantityxAddedDtos = userPunhisRepository.findSQLByQuantity();
			 
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		int days = 90;
		AverageDto averageDto = new AverageDto(quantityxAddedDtos.intValue()/days);
	
		return averageDto;
	}
}

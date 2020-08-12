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
	IUserPunishRepository _IUserPunhisRepository;
	
	@Transactional(readOnly=true)
	@Cacheable(value = "usersPunishCache")
	public List<UserPunishDto> findAllUserPunish() throws RuleslyException{		
		List<UserPunishEntity> _UserPunishEntitys;
		try {
			 _UserPunishEntitys = _IUserPunhisRepository.findSqlAll();
			 
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
				
		return UserPunishMapper.mapper(_UserPunishEntitys);
	}
	@Transactional(readOnly=true)
	@Cacheable(value = "quantityAndAddedsCache")
	public List<QuantityxAddedDto> findSQLByQuantityAndAddeds() throws RuleslyException{		
		List<Object[]> _QuantityxAddedDtos;
		try {
			 _QuantityxAddedDtos = _IUserPunhisRepository.findSQLByQuantityAndAddeds();
			 
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
				
		return QuantityPunishMapper.mapper(_QuantityxAddedDtos);
	}
	@Transactional(readOnly=true)
	@Cacheable(value = "averageCache")
	public AverageDto findSQLAverage() throws RuleslyException{		
		BigInteger _QuantityxAddedDtos;
		try {
			 _QuantityxAddedDtos = _IUserPunhisRepository.findSQLByQuantity();
			 
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		int days = 90;
		AverageDto _AverageDto = new AverageDto(_QuantityxAddedDtos.intValue()/days);
	
		return _AverageDto;
	}
}

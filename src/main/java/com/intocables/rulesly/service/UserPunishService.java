package com.intocables.rulesly.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;
import com.intocables.rulesly.repository.IUserPunishRepository;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.mapper.UserPunishMapper;

import  com.intocables.rulesly.service.exception.InternalServerErrorException;

@Service
public class UserPunishService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserPunishService.class);
	
	@Autowired
	IUserPunishRepository _IUserPunhisRepository;
	
	@Transactional(readOnly=true)
	public List<UserPunishDto> findAllUserPunish() throws RuleslyException{		
		List<UserPunishEntity> _UserPunishEntitys;
		try {
			 _UserPunishEntitys = _IUserPunhisRepository.findAll();
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
				
		return UserPunishMapper.mapper(_UserPunishEntitys);
	}
}

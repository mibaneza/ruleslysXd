package com.intocables.rulesly.service.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;
@Component
public class UserPunishMapper {

	public List<UserPunishDto> mapper (List<UserPunishEntity> userPunishEntitys){
		
		List<UserPunishDto> userPunishDtos = new ArrayList<>();
		for(UserPunishEntity _UserPunishEntity : userPunishEntitys){
			userPunishDtos.add(new UserPunishDto(_UserPunishEntity));
		}
		return userPunishDtos;
	}
	

}

package com.intocables.rulesly.service.mapper;


import java.util.ArrayList;
import java.util.List;

import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;

public class UserPunishMapper {

	public static List<UserPunishDto> mapper (List<UserPunishEntity> userPunishEntitys){
		
		List<UserPunishDto> userPunishDtos = new ArrayList<UserPunishDto>();
		for(UserPunishEntity _UserPunishEntity : userPunishEntitys){
			userPunishDtos.add(new UserPunishDto(_UserPunishEntity));
		}
		return userPunishDtos;
	}
	

}

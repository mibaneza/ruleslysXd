package com.intocables.rulesly.service.mapper;


import java.util.ArrayList;
import java.util.List;

import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.entity.UserPunishEntity;

public class UserPunishMapper {

	public static List<UserPunishDto> mapper (List<UserPunishEntity> _UserPunishEntitys){
		
		List<UserPunishDto> _UserPunishDtos = new ArrayList<UserPunishDto>();
		for(UserPunishEntity _UserPunishEntity : _UserPunishEntitys){
			_UserPunishDtos.add(new UserPunishDto(_UserPunishEntity));
		}
		return _UserPunishDtos;
	}
	

}

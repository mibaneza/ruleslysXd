package com.intocables.rulesly.service.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.intocables.rulesly.domain.UserPunish;
import com.intocables.rulesly.service.dto.UserPunishDTO;
@Component
public class UserPunishMapper {

	public List<UserPunishDTO> mapper (List<UserPunish> userPunishEntitys){
		
		List<UserPunishDTO> userPunishDTOs = new ArrayList<>();
		for(UserPunish _UserPunishEntity : userPunishEntitys){
			userPunishDTOs.add(new UserPunishDTO(_UserPunishEntity));
		}
		return userPunishDTOs;
	}
	

}

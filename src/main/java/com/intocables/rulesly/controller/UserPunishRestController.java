package com.intocables.rulesly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intocables.rulesly.dto.QuantityxAddedDto;
import com.intocables.rulesly.dto.UserPunishDto;
import com.intocables.rulesly.service.UserPunishService;
import com.intocables.rulesly.service.exception.RuleslyException;
import com.intocables.rulesly.service.message.RuleslyResponse;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/31574849548976465468764002013123411/")
public class UserPunishRestController {
	public  static final  String SUCCES = "Succes";
	public  static final  String OK = "OK";
	@Autowired
	UserPunishService userPunishService;
	@GetMapping(value="Gaaaaaa", produces = MediaType.APPLICATION_JSON_VALUE)
	public RuleslyResponse<List<UserPunishDto>> readGetUserPunish() throws RuleslyException{
		return new RuleslyResponse<>(SUCCES, String.valueOf(HttpStatus.OK), OK,
				userPunishService.findAllUserPunish());
	}
	@GetMapping(value="aea", produces = MediaType.APPLICATION_JSON_VALUE)
	public RuleslyResponse<List<QuantityxAddedDto>> readGetQuantityPunish() throws RuleslyException{
		return new RuleslyResponse<>(SUCCES, String.valueOf(HttpStatus.OK), OK,
				userPunishService.findSQLByQuantityAndAddeds());
	}
	@GetMapping(value="Raaaaaaa", produces = MediaType.APPLICATION_JSON_VALUE)
	public RuleslyResponse<Integer> readGetAverage() throws RuleslyException{
		return new RuleslyResponse<>(SUCCES, String.valueOf(HttpStatus.OK), OK,
				userPunishService.findSQLAverage());
	}
}

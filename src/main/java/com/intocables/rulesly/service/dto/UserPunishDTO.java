package com.intocables.rulesly.service.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.intocables.rulesly.domain.UserPunish;

public class UserPunishDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String added;
	
	private String type;
	
	private String reason;
	//patron n capas enfocada al dominio
	
	public UserPunishDTO(UserPunish userPunish) {
		this.added = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(userPunish.getAdded());
		this.type = userPunish.getType();
		this.reason = userPunish.getReason();
	}
	
	public UserPunishDTO(String added, String type, String reason) {
		this.added = added;
		this.type = type;
		this.reason = reason;
	}
	
	public UserPunishDTO() {}

	public String getAdded() {
		return added;
	}

	public void setAdded(String added) {
		this.added = added;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}


package com.intocables.rulesly.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import com.intocables.rulesly.entity.UserPunishEntity;

public class UserPunishDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String added;
	
	private String type;
	
	private String reason;
	//patron n capas enfocada al dominio
	
	public UserPunishDto(UserPunishEntity userPunishEntity) {
		this.added = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(userPunishEntity.getAdded());
		this.type = userPunishEntity.getType();
		this.reason = userPunishEntity.getReason();
	}
	
	public UserPunishDto(String added, String type, String reason) {
		this.added = added;
		this.type = type;
		this.reason = reason;
	}
	
	public UserPunishDto() {}

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


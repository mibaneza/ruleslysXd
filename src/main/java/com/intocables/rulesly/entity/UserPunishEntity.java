package com.intocables.rulesly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "user_punish")
@Immutable
public class UserPunishEntity {

    @Id
	@Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date added;
    
    @Column(nullable = false)
	private String type;

    @Column(nullable = false)
	private String reason;

	public UserPunishEntity() {}

	public UserPunishEntity(Date added, String type, String reason) {
		this.added = added;
		this.type = type;
		this.reason = reason;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
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
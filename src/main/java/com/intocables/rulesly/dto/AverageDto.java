package com.intocables.rulesly.dto;

import java.io.Serializable;

public class AverageDto implements Serializable {
	private static final long serialVersionUID = 1L;
	public int average;

	public AverageDto(int average) {
		this.average = average;
	}

	public AverageDto() {}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}
	

}

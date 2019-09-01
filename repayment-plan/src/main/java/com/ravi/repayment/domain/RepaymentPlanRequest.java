package com.ravi.repayment.domain;

import org.joda.time.DateTime;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;

public class RepaymentPlanRequest {
	
	private double loanAmount;
	private double nominalRate;
	private int duration;
	
	@JsonSerialize(using=DateTimeSerializer.class)
	private DateTime startDate;
	
	
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getNominalRate() {
		return nominalRate;
	}
	public void setNominalRate(double nominalRate) {
		this.nominalRate = nominalRate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
}
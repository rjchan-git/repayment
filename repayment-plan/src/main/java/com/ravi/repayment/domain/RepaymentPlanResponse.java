/**
 * 
 */
package com.ravi.repayment.domain;

import org.joda.time.DateTime;

/**
 * @author u271226
 *
 */
public class RepaymentPlanResponse {

	private double borrowerPaymentAmount;
	private DateTime date;
	private double initialOutstandingPrincipal;
	private double interest;
	private double principal;
	private double remainingOutstandingPrincipal;
	
	
	public RepaymentPlanResponse(double borrowerPaymentAmount, DateTime date,
			double initialOutstandingPrinicpal, double interest, double principal,
			double remainingOutstandingPrincipal) {
		this.borrowerPaymentAmount=borrowerPaymentAmount;
		this.date=date;
		this.initialOutstandingPrincipal=initialOutstandingPrinicpal;
		this.interest=interest;
		this.principal=principal;
		this.remainingOutstandingPrincipal=remainingOutstandingPrincipal;
	}
	public double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}
	public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}
	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}
	public void setRemainingOutstandingPrincipal(
			double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}
}
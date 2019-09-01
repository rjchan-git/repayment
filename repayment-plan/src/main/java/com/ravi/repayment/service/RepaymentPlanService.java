package com.ravi.repayment.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ravi.repayment.domain.RepaymentPlanRequest;
import com.ravi.repayment.domain.RepaymentPlanResponse;
import com.ravi.repayment.exception.ApplicationException;

@Service
public class RepaymentPlanService {

	private static final DecimalFormat df2 = new DecimalFormat("#.##");

	public List<RepaymentPlanResponse> generatePlan(RepaymentPlanRequest request)
			throws ApplicationException {
		validateRequest(request);
		double outstandingPrinicpal = Double.parseDouble(df2.format(request
				.getLoanAmount()));
		double durationInMonths = request.getDuration();
		List<RepaymentPlanResponse> responseList = new ArrayList<>();
		DateTime nextDateOfpayment = request.getStartDate();

		while (durationInMonths > 0) {

			double borrowerPaymentAmount = calculateAnnuityAmount(
					outstandingPrinicpal, durationInMonths);
			double interest = calculateInterest(outstandingPrinicpal,
					request.getNominalRate());
			double principal = Double.parseDouble(df2
					.format(borrowerPaymentAmount - interest));
			double remainingOutstandingAmount = Double.parseDouble(df2
					.format(outstandingPrinicpal - principal));

			responseList.add(new RepaymentPlanResponse(borrowerPaymentAmount,
					nextDateOfpayment, outstandingPrinicpal, interest,
					principal, remainingOutstandingAmount));

			outstandingPrinicpal = remainingOutstandingAmount;
			nextDateOfpayment = nextDateOfpayment.plusMonths(1);

			durationInMonths--;

		}

		return responseList;
	}

	private void validateRequest(RepaymentPlanRequest request)
			throws ApplicationException {
		if (StringUtils.isEmpty(request)) {
			throw new ApplicationException(
					"Bad request!!Request cannot be empty");
		} else if ((request.getLoanAmount() <= 0.0)
				|| (request.getDuration() <= 0.0)
				|| (request.getNominalRate() <= 0.0)) {
			throw new ApplicationException(
					"Bad request!! Either of Loan Amount,Duration and Nominalrate is non negative or is not provided.Please validate the request.");
		} else if (StringUtils.isEmpty(request.getStartDate())) {
			throw new ApplicationException(
					"Bad request!! StartDate is mandatory. Please validate the request");
		}

	}

	private double calculateInterest(double initialOutstandingPrincipal,
			double nominalRate) {
		double interest = (nominalRate * 30 * initialOutstandingPrincipal / 360) / 100;
		return Double.parseDouble(df2.format(interest));
	}

	private double calculateAnnuityAmount(double outstandingPrincipal,
			double durationInMonths) {
		/*
		 * R is the rate of interest per month [if the interest rate per annum
		 * is 5%, then the rate of interest will be 5/(12 x 100)].
		 */
		double rateOfInterest = 5;
		rateOfInterest = rateOfInterest / (12 * 100);

		return Double.parseDouble(df2.format((outstandingPrincipal
				* rateOfInterest * Math.pow(1 + rateOfInterest,
				durationInMonths))
				/ (Math.pow(1 + rateOfInterest, durationInMonths) - 1)));
	}
}
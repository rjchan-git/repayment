package com.ravi.repayment.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ravi.repayment.domain.RepaymentPlanRequest;
import com.ravi.repayment.domain.RepaymentPlanResponse;
import com.ravi.repayment.exception.ApplicationException;

@RunWith( MockitoJUnitRunner.class)
public class RepaymentPlanServiceTest {
	
	@InjectMocks
	private RepaymentPlanService repaymentPlanService;

	
	@Test
	public void test() throws ApplicationException {
		
		RepaymentPlanRequest request=new RepaymentPlanRequest();
		request.setLoanAmount(5000);
		request.setDuration(24);
		request.setNominalRate(5);
		request.setStartDate(new DateTime("2018-01-01T00:00:01Z"));
		List<RepaymentPlanResponse> list=repaymentPlanService.generatePlan(request);
		assertEquals(Boolean.TRUE,!list.isEmpty());
		assertEquals(24, list.size());
	}
	
	
	@Test(expected=ApplicationException.class)
	public void repaymentPlanInvalidLoanAmount() throws ApplicationException  {
		RepaymentPlanRequest request=new RepaymentPlanRequest();
		request.setLoanAmount(-5000);
		request.setDuration(24);
		request.setNominalRate(5);
		request.setStartDate(new DateTime("2018-01-01T00:00:01Z"));
		List<RepaymentPlanResponse> list=repaymentPlanService.generatePlan(request);
		assertEquals(Boolean.TRUE,list.isEmpty());
	}
	
	@Test(expected=ApplicationException.class)
	public void repaymentPlanInvalidDuration() throws ApplicationException  {
		RepaymentPlanRequest request=new RepaymentPlanRequest();
		request.setLoanAmount(5000);
		request.setDuration(-24);
		request.setNominalRate(5);
		request.setStartDate(new DateTime("2018-01-01T00:00:01Z"));
		List<RepaymentPlanResponse> list=repaymentPlanService.generatePlan(request);
		assertEquals(Boolean.TRUE,list.isEmpty());
	}
	
	@Test(expected=ApplicationException.class)
	public void repaymentPlanWithNoStartDate() throws ApplicationException  {
		RepaymentPlanRequest request=new RepaymentPlanRequest();
		request.setLoanAmount(5000);
		request.setDuration(24);
		request.setNominalRate(5);
		List<RepaymentPlanResponse> list=repaymentPlanService.generatePlan(request);
		assertEquals(Boolean.TRUE,list.isEmpty());
	}
	
	@Test(expected=ApplicationException.class)
	public void repaymentPlanWithNegativeNominalRate() throws ApplicationException  {
		RepaymentPlanRequest request=new RepaymentPlanRequest();
		request.setLoanAmount(5000);
		request.setDuration(24);
		request.setNominalRate(-5);
		request.setStartDate(new DateTime("2018-01-01T00:00:01Z"));
		List<RepaymentPlanResponse> list=repaymentPlanService.generatePlan(request);
		assertEquals(Boolean.TRUE,list.isEmpty());
	}
}

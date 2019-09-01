
package com.ravi.repayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.repayment.domain.RepaymentPlanRequest;
import com.ravi.repayment.domain.RepaymentPlanResponse;
import com.ravi.repayment.exception.ApplicationException;
import com.ravi.repayment.service.RepaymentPlanService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Ravi
 *
 */
@RestController
public class RepaymentPlanController {

	@Autowired
	private RepaymentPlanService repaymentPlanService;


	@ApiOperation(value = "Get the repayment plan", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved repayment plans for the customer"),
			@ApiResponse(code = 500, message = "There was an error proccesing the request. Please try again later") })
	@RequestMapping(value = "generate-plan", method = RequestMethod.POST, produces = { "application/JSON" }, consumes = { "application/JSON" })
	public List<RepaymentPlanResponse> generatePlan( @RequestBody RepaymentPlanRequest request) throws ApplicationException {
		return repaymentPlanService.generatePlan(request);
	}

	@RequestMapping(value = "TEST", method = RequestMethod.GET)
	public String test() {
		return "Hello i m Ravi";
	}
}

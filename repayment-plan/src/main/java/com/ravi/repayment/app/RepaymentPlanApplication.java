package com.ravi.repayment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ravi.repayment")
public class RepaymentPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepaymentPlanApplication.class, args);
	}

}

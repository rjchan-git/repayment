# repayment
repayment-app application is developed as a rest webservice with endpoint exposed for calculating the payment plan for the given customer
The following are the capabilities of repayment-app
1) A service which return the payment details for the customer for the given period
	
APP :
==========
	. The app is developed using Spring-Boot and spring-REST
	. The app runs on the port 8080
	  
API-DOCUMENTATION
===================
Once the app starts, the api documentation can be found on 
http://localhost:8080/swagger-ui.html#/

APP-USAGE:
===================
build the jar using maven and then execute the below steps

1) The app can be started as a standalone java application 
       java -jar repayment-app-0.0.1-SNAPSHOT.jar
	   
2) Can be started using Docker 
      . Docker file is in the project directory
	      
		  COMMANDS:
		  ===========
		  sudo docker build -t ravi/repayment-app:latest .
		  once the image is ready, create and start the container
		  sudo docker run -p 8080:8080 ravi/repayment-app
		  
		  

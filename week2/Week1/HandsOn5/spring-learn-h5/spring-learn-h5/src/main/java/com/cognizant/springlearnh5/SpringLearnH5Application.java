package com.cognizant.springlearnh5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
public class SpringLearnH5Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnH5Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnH5Application.class, args);
		displayCountry();
	}
	
	public static void displayCountry() {
		LOGGER.info("Start");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		 LOGGER.info("END");
	}

}

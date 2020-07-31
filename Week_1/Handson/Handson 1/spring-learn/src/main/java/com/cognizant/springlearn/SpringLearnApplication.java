package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
     void displayDate() throws ParseException
     { 
    	 LOGGER.info("start");
    	 System.out.println("hellooo HA 1 ");
    	 ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
    	 SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
    	 Date date = format.parse("31/12/2018");
    	 String strDate = format.format(date);

    	 LOGGER.debug(strDate);
    	 System.out.println(date);
    	 LOGGER.info("End");
    }
    void displayCountry()
    {
    	LOGGER.info("start");
    	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    	
     	Country country = (Country) context.getBean("country", Country.class);
      	Country anotherCountry = context.getBean("country", Country.class);
     	LOGGER.debug("Country : {}", country.toString());
    	LOGGER.debug("Country : {}", anotherCountry.toString());
    	
    	LOGGER.info("End");
    }
    void displayCountries()
    {
    	LOGGER.info("start");
    	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
    	ArrayList<Country> country =new ArrayList<Country>();
    	 country = context.getBean("countryList", java.util.ArrayList.class);
    	LOGGER.debug("Country : {}", country.toString());
    }
    
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
       SpringLearnApplication s=new SpringLearnApplication();
		s.displayDate();
		s.displayCountries();

		
	}

}

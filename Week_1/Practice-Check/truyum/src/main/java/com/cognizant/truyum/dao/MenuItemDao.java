package com.cognizant.truyum.dao;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemDao  {
	private final static Logger LOGGER = LoggerFactory.getLogger(MenuItemDao.class);	
	public static ArrayList<MenuItem> Menu_List = new ArrayList<MenuItem>();
	
	@Autowired
	MenuItemDao menuItemDao;
	
	public MenuItemDao() {
		LOGGER.info("Start**constructor");
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		Menu_List = context.getBean("menuList", java.util.ArrayList.class);
		LOGGER.debug("Menu : {}", Menu_List.toString());
		LOGGER.info("End**Constructor");
	}

	public ArrayList<MenuItem> getMenuItems() {
		/*LOGGER.info("Start**getItems");
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		Menu_List = context.getBean("menuList", java.util.ArrayList.class);
		LOGGER.info("End**getItems");*/
		return Menu_List;
	}

	
	public MenuItem findMenuItem(int id) {
		LOGGER.info("Start**FindListfromid");
		for(MenuItem g : Menu_List) {
			
			if(g.getId()==id) {
				LOGGER.debug("Menu : {}", g.toString());
				LOGGER.info("End**FindListfromid");
				return g;
            }
        }
		LOGGER.info("End**FindListfromid");
		return null;
	}
	
	public MenuItem findById(int c_id) {
		MenuItem m=Menu_List.get(c_id);
		return m;
	}
	public MenuItem save(MenuItem menuItem) {
		LOGGER.info("Start");
		LOGGER.info("End");
			return menuItem;
	}

	
}

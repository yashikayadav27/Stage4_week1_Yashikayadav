package com.cognizant.truyum.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	
	@Autowired
	MenuItemDao menuItemDao;
	
	@GetMapping("/all")
	public ArrayList<MenuItem> getMenuItems() {
	return menuItemDao.getMenuItems();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
	return menuItemDao.findMenuItem(id);
	}
	
	@PutMapping("/save")
	public MenuItem save(@RequestBody MenuItem menuItem) {
		return menuItemDao.save(menuItem);
	}
	
	
	
}

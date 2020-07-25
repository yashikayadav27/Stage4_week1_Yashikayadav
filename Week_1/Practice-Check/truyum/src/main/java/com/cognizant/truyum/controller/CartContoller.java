package com.cognizant.truyum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.EmptyFoundException;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@RestController
@RequestMapping("/cart")
public class CartContoller {

	List<MenuItem> list = null;
	@Autowired
	MenuItemDao menuItemService;
	@Autowired
	CartDao cartDao;
	
	@GetMapping("/itemlist")
	public ArrayList<MenuItem> getMenuItems() {
		return menuItemService.getMenuItems();
	}
	
	@GetMapping("/cartlist")
	public List<MenuItem> getList() {
		list = cartDao.getAllCartItems();
		if(list.equals(null)) {
			throw new EmptyFoundException();
		}
		return list;
	}
	
	@PostMapping("/addtocart/{id}")
	public void addedToFav(@PathVariable int id) {
		id=id-1;
		cartDao.addCartItem(id);
	}
		
	@DeleteMapping("/delete/{id}")
	public void deleteItem(@PathVariable int id ) {
		cartDao.removeFromCart(id);	
	}
}
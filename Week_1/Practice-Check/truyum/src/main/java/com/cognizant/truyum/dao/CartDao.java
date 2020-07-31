package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartDao {
	private final static Logger LOGGER = LoggerFactory.getLogger(CartDao.class);
	public static ArrayList<Cart> cart = new ArrayList<Cart>();
	List<MenuItem> mov = new ArrayList<MenuItem>();
	
	@Autowired
	MenuItemDao menuItemDao;
	@Autowired
	CartDao cartDao;

	
	public CartDao() {
	}

	public void addCartItem(int menuItemId) {
		int idc = cart.size(); 
		
		 Cart fav = new Cart(idc,1,menuItemId);  
		 LOGGER.info("*****before add to cart*****");
          cart.add(fav);
          for (Cart f : cart) {
  			MenuItem item = menuItemDao.findById(f.getC_id());
  			
  			if(!mov.contains(item)) {
  				mov.add(item);
  			}
  	         System.out.println(mov);
  	     }
  	
	}
	
	public List<MenuItem> getAllCartItems() throws EmptyFoundException {
		return mov;
	}

	public void removeFromCart(int id) {
		// TODO Auto-generated method stub
		
		for(MenuItem m:mov) {
			if(m.getId() == id) {
				mov.remove(m);
			} 
		}
	}
}
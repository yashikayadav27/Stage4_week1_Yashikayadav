package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoCollectionImpl implements CartDao {

	@Autowired
	
private MenuItemDaoCollectionImpl menuItemDaoCollectionImpl;
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);

	private static HashMap<String, Cart> userCarts;
	
	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		LOGGER.info("START ADD CART ITEM");
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
		LOGGER.info(userCarts.toString());
		LOGGER.info("END ADD CART ITEM");

	}

	@Override
	public List<MenuItem> getAllCartItems(String userId)throws CartEmptyException {
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			if (menuItemList.isEmpty()) {
				throw (new CartEmptyException());
			} else {
				double total = 0.0;
				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
			return menuItemList;
		} else {
			throw (new CartEmptyException());
		}
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) throws CartEmptyException{
		// TODO Auto-generated method stub
		int flag=0;
		LOGGER.info("START REMOVE CART ITEM");
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				flag=1;
				menuItemList.remove(i);

				break;
			}
		}
		if(flag==0) 
			throw (new CartEmptyException());
		LOGGER.info("END REMOVE CART ITEM");
	}
	

}

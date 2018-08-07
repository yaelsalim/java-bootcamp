package com.globant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.models.Product;
import com.globant.models.ShoppingCart;
import com.globant.repositories.CartRepository;

/**
 * This class implements the ShoppingCartService interface
 * 
 * @author Yael Salim
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	CartRepository shoppingCarts;

	public void create(String userName) {
		shoppingCarts.save(new ShoppingCart(userName));
	}

	public Double payOrder(String userName) {
		return shoppingCarts.findByUserName(userName).buyProducts();
	}

	public void saveCart(ShoppingCart cart) {
		shoppingCarts.save(cart);
	}

	public void deleteCart(String userName) {
		shoppingCarts.delete(shoppingCarts.findByUserName(userName));
	}

	public void addProductToCart(Product newProduct, String userName) {
		ShoppingCart cart = shoppingCarts.findByUserName(userName);
		cart.addItemToCart(newProduct);
		shoppingCarts.save(cart);
	}

	public void deleteProductFromCart(Product newProduct, String userName) {
		shoppingCarts.findByUserName(userName).deleteItemFromCart(newProduct);

	}

	public List<ShoppingCart> getCarts() {
		return shoppingCarts.findAll();
	}
	
	public ShoppingCart findByUserName(String userName) {
		return shoppingCarts.findByUserName(userName);
	}

}

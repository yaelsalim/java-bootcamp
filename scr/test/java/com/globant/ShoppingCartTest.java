package com.globant;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.globant.models.Product;
import com.globant.services.ShoppingCartService;
import com.globant.services.ShoppingCartServiceImpl;

public class ShoppingCartTest {

	private Product productMock;

	@Before
	public void setUp() throws Exception {
		productMock = Mockito.mock(Product.class);
	}

	@Test
	public void whenACartIsCreatedThenItIsEmpty() {

		ShoppingCartService cartService = new ShoppingCartServiceImpl();

		cartService.create("Yael_salim");

		assertEquals(0, cartService.getCart("Yael_salim").getCartSize());

	}

	@Test
	public void whenAProductIsAddedToTheCart() {

		ShoppingCartService cartService = new ShoppingCartServiceImpl();

		cartService.create("Yael_salim");

		cartService.addProductToCart(productMock, "Yael_salim");

		assertEquals(1, cartService.getCart("Yael_salim").getCartSize());

	}

	@Test
	public void whenAProductIsDeletedFromTheCart() {
		ShoppingCartService cartService = new ShoppingCartServiceImpl();

		cartService.create("Yael_salim");

		Product newProduct = new Product("TV", 1, 2000.0);

		cartService.addProductToCart(newProduct, "Yael_salim");

		cartService.deleteProductFromCart(newProduct, "Yael_salim");

		assertEquals(0, cartService.getCart("Yael_salim").getCartSize());

	}

	@Test
	public void whenTheCostOfTheCartIsCalculated() {
		ShoppingCartService cartService = new ShoppingCartServiceImpl();

		cartService.create("Yael_salim");

		Product item1 = new Product("TV", 2, 2000.0);

		Product item2 = new Product("Bed", 1, 750.0);

		cartService.addProductToCart(item1, "Yael_salim");

		cartService.addProductToCart(item2, "Yael_salim");

		assertEquals(2750.0, cartService.getCart("Yael_salim").buyProducts().doubleValue(), 0.0);

	}
}

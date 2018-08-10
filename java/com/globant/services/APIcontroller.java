package com.globant.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globant.models.Product;
import com.globant.models.ShoppingCart;
import com.globant.models.User;

import io.swagger.annotations.ApiOperation;

/**
 * API's controller. Handles HTTP requests.
 * 
 * @author Yael Salim
 *
 */

@Controller
public class APIcontroller {

	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService cartService;
	@Autowired
	private ProductService productService;

	// This controller is simpified. It does not use SpringSecurity for user
	// authentication.
	// It uses a variable to keep in memory the user id.
	private String sessionID;

	/**
	 * Handles GET request for the users in the database
	 * 
	 * @return
	 */
	@GetMapping(value = "/users")
	public @ResponseBody List<User> getUsers() {

		return userService.getUsers();
	}

	/**
	 * Handles GET request for the user registration
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/register")
	public String registerForm(Model model) {

		model.addAttribute("User", new User());

		return "register";

	}

	/**
	 * Handles POST request for the user registration
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping("/register")
	@ApiOperation(value = "Registers a new user", nickname = "Register user")
	public String register(@ModelAttribute User request, Model model) {

		User usersFound = userService.findByUserName(request.getUsername());

		if (usersFound != null) {

			model.addAttribute("userNameErr", true);

			model.addAttribute("User", new User());

			return "register";

		} else {

			userService.create(request.getUsername(), request.getName(), request.getPassword());

			sessionID = request.getUsername();

			return "home";

		}
	}

	/**
	 * Handles the login form
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/login")
	@ApiOperation(value = "Logs in a user.", nickname = "Login user.")
	public String loginUser(Model model) {

		model.addAttribute("User", new User());

		return "login";

	}

	/**
	 * Handles the user login
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@PostMapping("/login")
	@ApiOperation(value = "Logs in a user.", nickname = "Login user.")
	public String loginUser(@ModelAttribute User request, Model model) {

		User usersFound = userService.findByUserName(request.getUsername());

		if (usersFound == null || !request.getPassword().equals(usersFound.getPassword())) {

			if (usersFound == null) {

				model.addAttribute("userNameErr", true);

			} else {

				model.addAttribute("passwordErr", true);

			}
			model.addAttribute("User", new User());

			return "login";

		} else {
			model.addAttribute("userLogged", true);

			sessionID = request.getUsername();

			return "home";
		}
	}

	/**
	 * Product Controller
	 */
	/**
	 * Handles GET request for the users in the database
	 * 
	 * @return
	 */
	@GetMapping(value = "/products")
	public @ResponseBody List<Product> getProducts() {

		return productService.listProducts();
	}

	/**
	 * Handles GET request for the users in the database
	 * 
	 * @return
	 */
	@GetMapping(value = "/carts")
	public @ResponseBody List<ShoppingCart> getCarts() {

		return cartService.getCarts();
	}

	/**
	 * Handles GET request when adding products to the cart
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/addToCart")
	@ApiOperation(value = "Add product to cart.", nickname = "Add product.")
	public String addToCart(Model model) {
		List<Product> products = productService.listProducts();
		model.addAttribute("productList", products);
		model.addAttribute("product", new Product());

		return "addToCart";
	}

	/**
	 * Adds product to the cart
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/addToCart")
	@ResponseBody
	@ApiOperation(value = "Add product.", nickname = "Add product.")
	public String addToCartResult(@ModelAttribute Product request) {

		if (request.getQuantity() != null && request.getQuantity() > 0) {

			ShoppingCart cart = cartService.findByUserName(sessionID);

			Product product = productService.findByName(request.getName());

			product.setQuantity(request.getQuantity());

			if (cart == null) {

				cartService.create(sessionID);
			}

			cartService.addProductToCart(product, sessionID);

			return "Products added to the cart";

		} else {
			return "Invalid product amount";

		}
	}

	/**
	 * Finds a product by category
	 * 
	 * @param category
	 * @return
	 */
	@GetMapping("/findByCategory")
	@ApiOperation(value = "Find product by category.", nickname = "Find product by category.")
	public String findByCategory(Model model) {

		model.addAttribute("product", new Product());

		return "findByCategory";
	}

	/**
	 * Returns a list of products for a given category
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("/findByCategory")
	@ApiOperation(value = "Find product by category.", nickname = "Find product by category.")
	public String findByCategory(@ModelAttribute Product request, Model model) {

		List<Product> products = productService.findByCategory(request.getCategory());

		if (products.isEmpty()) {

			return "home";

		} else {

			model.addAttribute("productList", products);

			model.addAttribute("product", new Product());

			return "findByCategory";

		}
	}

	/**
	 * Finds a product by category
	 * 
	 * @param category
	 * @return
	 */
	@GetMapping("/findByName")
	@ApiOperation(value = "Find product by name.", nickname = "Find product by name.")
	public String findByName(Model model) {

		model.addAttribute("product", new Product());

		return "findByName";
	}

	/**
	 * Returns a list of products for a given category
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("/findByName")
	@ApiOperation(value = "Find product by name.", nickname = "Find product by name.")
	public String findByName(@ModelAttribute Product request, Model model) {

		Product product = productService.findByName(request.getName());

		List<Product> products = new ArrayList<>();

		products.add(product);

		if (product == null) {

			return "home";

		} else {

			model.addAttribute("productList", products);

			model.addAttribute("product", new Product());

			return "findByName";
		}
	}

	/**
	 * Calculates the total cost
	 * 
	 * @return
	 */
	@GetMapping("/buyProducts")
	@ResponseBody
	@ApiOperation(value = "Buy products.", nickname = "Buy products.")
	public String buyProducts() {

		ShoppingCart cart = cartService.findByUserName(sessionID);

		if (cart == null) {

			return "Cart not found for user name : " + sessionID;

		} else {

			return "The total cost is : " + cartService.payOrder(sessionID);
		}

	}

	/**
	 * Saves the current cart
	 * 
	 * @return
	 */
	@RequestMapping(value = "/saveCart", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	@ApiOperation(value = "Save user cart.", nickname = "Save user cart.")
	public String saveCart() {

		ShoppingCart cart = cartService.findByUserName(sessionID);

		if (cart == null) {

			return "Cart not found for user name : " + sessionID;

		} else {

			cartService.saveCart(cart);

			return "Cart was saved successfully.";

		}

	}

	/**
	 * Delete a product from cart
	 * 
	 * @return
	 */
	@GetMapping(value = "/deleteFromCart")
	@ApiOperation(value = "Deletes a product from cart.", nickname = "Delete a product from cart.")
	public String deleteFromCart(Model model) {

		List<Product> products = productService.listProducts();
		model.addAttribute("productList", products);
		model.addAttribute("product", new Product());

		return "deleteFromCart";
	}

	/**
	 * Delete a product from cart
	 * 
	 * @return
	 */
	@PostMapping(value = "/deleteFromCart")
	@ResponseBody
	@ApiOperation(value = "Deletes a product from cart.", nickname = "Delete a product from cart.")
	public String deleteFromCart(@ModelAttribute Product request) {

		ShoppingCart cart = cartService.findByUserName(sessionID);

		Product product = productService.findByName(request.getName());

		if (cart == null) {

			return "Cart not found for user name : " + sessionID;

		} else {
			if (!cart.getProductList().contains(product)) {

				return "Product was not found in the cart.";
			}

			cart.deleteItemFromCart(product);

			cartService.saveCart(cart);

			return "Product was removed successfully.";

		}

	}

}

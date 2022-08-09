package com.spd.smartcooler;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spd.smartcooler.dao.jdbc.JdbcCoolerDao;
import com.spd.smartcooler.dao.jdbc.JdbcProductDao;
import com.spd.smartcooler.dao.jdbc.JdbcRecipeDao;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.provider.Provider;

@WebServlet(urlPatterns = { "/dispatcherRecipe" })
public class StartServlet extends HttpServlet {

	public static final String PATH_CONFIG = "/home/anton/eclipse-workspace/smartcooler/src/main/resources/config.properties";
	private static final String BACK_TO_RECIPIES = "<a href=/smartcooler/dispatcher.jsp>Back Recipies</a>";
	private static final long serialVersionUID = 852078932876860504L;
	private Connection connection;
	private JdbcProductDao productDao;
	private JdbcCoolerDao coolerDao;
	private JdbcRecipeDao recipeDao;

	public StartServlet() {
		Provider provider = new Provider();
		connection = provider.connect(PATH_CONFIG);
		productDao = new JdbcProductDao(provider);
		coolerDao = new JdbcCoolerDao(provider, productDao);
		recipeDao = new JdbcRecipeDao(provider, productDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// split process for several methods

	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (connection != null) {
				String action = request.getServletPath();
				if (action.equalsIgnoreCase("/dispatcherRecipe")) {
					String recipeName = request.getParameter("recipe");
					response.setContentType("text/html");
					List<Product> coolerProducts = coolerDao.findProductsByCoolerModel("model");
					List<Product> recipeProducts = recipeDao.findProductsByRecipeName(recipeName);

					Map<String, Integer> coolerProductsMap = coolerProducts.stream()
							.collect(Collectors.toMap(Product::getName, Product::getCount));
					Map<String, Integer> recipeProductsMap = recipeProducts.stream()
							.collect(Collectors.toMap(Product::getName, Product::getCount));
					Map<String, Integer> shoppingListMap = new HashMap<>();
					response.getWriter().append("Cooler : " + "<br>" + coolerProductsMap + "<br>");
					response.getWriter().append("Recipe : " + "<br>" + recipeProductsMap + "<br>");
					for (Map.Entry<String, Integer> pairCooler : coolerProductsMap.entrySet()) {
						for (Map.Entry<String, Integer> pairRecipe : recipeProductsMap.entrySet()) {
							if (pairRecipe.getKey().equals(pairCooler.getKey())) {
							} else if (!coolerProductsMap.containsKey(pairRecipe.getKey())) {
								shoppingListMap.put(pairRecipe.getKey(), pairRecipe.getValue());
							}
						}
					}
					response.getWriter().append("Shopping List <br>");
					if (!shoppingListMap.isEmpty()) {
						response.getWriter().append("" + shoppingListMap + "<br>");
						for (Map.Entry<String, Integer> pairShopList : shoppingListMap.entrySet()) {
							Product product = productDao.findProductByName(pairShopList.getKey());
							double result = product.getPrice() * product.getCount();
							response.getWriter()
									.append(product.getName() + " (" + product.getCount() + ") : "
											+ Math.round(result * 100.0) / 100.0 + " UAH " + "(" + product.getType()
											+ ") <br>");
						}
						response.getWriter().append(BACK_TO_RECIPIES);
					} else {
						response.getWriter().append("empty <br>" + BACK_TO_RECIPIES);
					}
				}
			} else {
				response.getWriter().append("no connection");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

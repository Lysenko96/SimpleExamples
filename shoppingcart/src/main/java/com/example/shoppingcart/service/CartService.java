package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Cart;
import com.example.shoppingcart.entity.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartService {

    private ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public Set<Cart> clearCarts(Set<Cart> carts, Set<Cart> cartList, Product product) {
        if (cartList == null) carts.removeIf(cart -> cart.getCategory().equals(product.getCategory()));
        else cartList.removeIf(cart -> cart.getCategory().equals(product.getCategory()));
        return carts;
    }


    public Set<Cart> filterCarts(Set<Cart> carts, List<Product> products){
        Set<Cart> cartsUnique = new HashSet<>();
        if(carts != null) {
            Map<Long, Integer> cartIdQuantity = carts.stream().collect(Collectors.toMap(Cart::getId, Cart::getQuantity, Integer::sum));
            System.out.println(cartIdQuantity);
            for(Product product : products) {
                if (cartIdQuantity.containsKey(product.getId())) {
                    int quantity = cartIdQuantity.get(product.getId());
                    cartsUnique.add(new Cart(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getImage(), quantity, quantity * product.getPrice()));
                }
            }
            System.out.println(cartsUnique);
        }
        return cartsUnique;
    }

    public Integer calculateQuantity(String quantityStr) {

        int quantity;
        if (quantityStr == null) quantity = 1;
        else if (quantityStr.isEmpty()) quantity = 0;
        else quantity = Math.abs(Integer.parseInt(quantityStr));

        return quantity;
    }

    public Set<Cart> saveCarts(Set<Cart> carts, Set<Cart> cartList, Product product, HttpSession session, int quantity) {
        Cart cart = new Cart(product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getImage(), quantity, product.getPrice() * quantity);
        if (cartList == null) {
            carts.add(cart);
            //session.setAttribute("carts", carts);
        } else {
            carts = cartList;
            if (!carts.contains(cart) && cart.getQuantity().equals(quantity)) {
                carts.add(cart);
                System.out.println("product added");

            } else System.out.println("product exist");
        }
        System.out.println("########## " + carts);
        return carts;
    }
}

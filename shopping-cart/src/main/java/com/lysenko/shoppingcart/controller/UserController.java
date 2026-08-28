package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Cart;
import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.OrderRequest;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CartService;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.OrderService;
import com.lysenko.shoppingcart.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private static final String ERROR = "error";
    private static final String SUCCESS = "success";

    private final UserService userService;
    private final CategoryService categoryService;
    private final CartService cartService;
    private final OrderService orderService;

    @ModelAttribute
    public void getUserDetails(Principal login, Model model) {
        if (login != null) {
            String email = login.getName();
            UserCustom user = userService.getUserByEmail(email);
            Integer countCart = cartService.getCountCart(user.getId());
            model.addAttribute("user", user);
            model.addAttribute("countCart", countCart);
        }
        List<Category> allActive = categoryService.findAllActive();
        model.addAttribute("categories", allActive);
    }

    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "redirect:/shopping-cart/";
    }

    @GetMapping("/addCart")
    public String addToCart(@RequestParam Integer pid, @RequestParam Integer uid, HttpSession session) {
        Cart saveCart = cartService.saveCart(pid, uid);
        if (ObjectUtils.isEmpty(saveCart)) {
            session.setAttribute(ERROR, "Product add to cart failed");
        } else {
            session.setAttribute(SUCCESS, "Product added to cart");
        }
        return "redirect:/shopping-cart/product-details/" + pid;
    }

    @GetMapping("/cart")
    public String loadCart(Principal p, Model m) {
        UserCustom userCustom = getLoggedInUserCustom(p);
        List<Cart> carts = cartService.getCartsByUserId(userCustom.getId());
        m.addAttribute("carts", carts);
        if (carts.isEmpty()) {
            return "/user/cart";
        }
        m.addAttribute("totalOrderPrice", carts.getLast().getTotalOrderPrice());
        return "/user/cart";
    }

    @GetMapping("/cartQuantityUpdate")
    public String updateCartQuantity(@RequestParam String symbol, @RequestParam Integer cid) {
        cartService.updateQuantity(symbol, cid);
        return "redirect:/shopping-cart/cart";
    }

    @GetMapping("/orders")
    public String orderPage(Principal p, Model m) {
        UserCustom userCustom = getLoggedInUserCustom(p);
        List<Cart> carts = cartService.getCartsByUserId(userCustom.getId());
        m.addAttribute("carts", carts);
        if (carts.isEmpty()) {
            return "/user/cart";
        }
        BigDecimal orderPrice = carts.getLast().getTotalOrderPrice();
        BigDecimal totalOrderPrice = carts.getLast().getTotalOrderPrice()
                .add(BigDecimal.valueOf(250).add(BigDecimal.valueOf(100)));
        m.addAttribute("orderPrice", orderPrice);
        m.addAttribute("totalOrderPrice", totalOrderPrice);
        return "/user/order";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute OrderRequest request, Principal p) {
        log.info("OrderRequest: {}", request);
        UserCustom user = getLoggedInUserCustom(p);
        orderService.saveOrder(user.getId(), request);
        return "redirect:/shopping-cart/success";
    }

    @GetMapping("/success")
    public String loadSuccess() {
        return "/user/success";
    }

    private UserCustom getLoggedInUserCustom(Principal p) {
        String email = p.getName();
        UserCustom userCustom = userService.getUserByEmail(email);
        return userCustom;
    }

}

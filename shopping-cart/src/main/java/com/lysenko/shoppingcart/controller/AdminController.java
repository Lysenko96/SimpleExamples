package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.Product;
import com.lysenko.shoppingcart.model.UserCustom;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.ProductService;
import com.lysenko.shoppingcart.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/shopping-cart/admin")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    private static final String CATEGORIES = "categories";
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    private static final String IMG_PATH = "static/img";
    private static final String CATEGORY_IMG = "category_img";
    private static final String PRODUCT_IMG = "product_img";
    private static final String DEFAULT_IMG_NAME = "unknown.jpg";
    private static final String REDIRECT_CATEGORY = "redirect:/shopping-cart/admin/category";
    private static final String REDIRECT_EDIT_CATEGORY = "redirect:/shopping-cart/admin/editCategory/";
    private static final String REDIRECT_SAVE_PRODUCT = "redirect:/shopping-cart/admin/add-product";
    private static final String REDIRECT_EDIT_PRODUCT = "redirect:/shopping-cart/admin/editProduct/";

    private final CategoryService categoryService;
    private final ProductService productService;

    private final UserService userService;

    @ModelAttribute
    public void getUserDetails(Principal login, Model model) {
        if (login != null) {
            String email = login.getName();
            UserCustom user = userService.getUserByEmail(email);
            model.addAttribute("user", user);
        }
        List<Category> allActive = categoryService.findAllActive();
        model.addAttribute(CATEGORIES, allActive);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "admin/index";
    }

    @GetMapping("/add-product")
    public String adminAddProduct(Model model) {
        model.addAttribute(CATEGORIES, categoryService.findAll());
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute(CATEGORIES, categoryService.findAll());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, @RequestParam(value = "isActive", required = false) Boolean isActive,
                               @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {

        String fileName = file != null ? file.getOriginalFilename() : DEFAULT_IMG_NAME;
        category.setImageName(fileName);
        category.setIsActive(Objects.requireNonNullElse(isActive, false));
        log.info("saveCategory file: {}", file);
        if (Boolean.TRUE.equals(categoryService.existCategory(category.getName()))) {
            session.setAttribute(ERROR, "Category name already exists");
            return REDIRECT_CATEGORY;
        }
        Category categorySave = categoryService.save(category);
        if (categorySave == null) {
            session.setAttribute(ERROR, "Category saved failed");
            return REDIRECT_CATEGORY;
        }
        File saveFile = new ClassPathResource(IMG_PATH).getFile();
        Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + CATEGORY_IMG + File.separator + fileName);
        log.info("saveCategory path: {}", path);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
        session.setAttribute(SUCCESS, "Category saved success");
        return REDIRECT_CATEGORY;
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id, HttpSession session) {
        boolean isDeleted = categoryService.deleteById(id);
        if (!isDeleted) {
            session.setAttribute(ERROR, "Category deleted failed");
        } else {
            session.setAttribute(SUCCESS, "Category deleted successfully");
        }
        return REDIRECT_CATEGORY;
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "admin/edit_category";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category, @RequestParam(value = "isActive", required = false) Boolean isActive,
                                 @RequestParam(value = "file", required = false) MultipartFile file, HttpSession session) throws IOException {

        Category categoryById = categoryService.findById(category.getId());
        String imageName = file != null ? file.getOriginalFilename() : DEFAULT_IMG_NAME;
        if (categoryById != null) {
            categoryById.setName(category.getName());
            categoryById.setImageName(imageName);
            categoryById.setIsActive(isActive);
        }
        Category updateCategory = categoryService.save(categoryById);
        if (updateCategory == null) {
            session.setAttribute(ERROR, "Category update failed");
            return REDIRECT_EDIT_CATEGORY + category.getId();
        }
        File saveFile = new ClassPathResource(IMG_PATH).getFile();
        Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + CATEGORY_IMG + File.separator + imageName);
        log.info("updateCategory path: {}", path);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
        session.setAttribute(SUCCESS, "Category updated successfully");
        return REDIRECT_EDIT_CATEGORY + category.getId();
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product, @RequestParam(value = "file", required = false) MultipartFile file,
                              HttpSession session) throws IOException {

        String imageName = file != null ? file.getOriginalFilename() : product.getImage();
//        String imageName = file.isEmpty() ? product.getImage() : file.getOriginalFilename();
        product.setImage(imageName);
        product.setDiscount(0);
        product.setDiscountPrice(product.getPrice());
        Product saveProduct = productService.save(product);
        if (saveProduct == null) {
            session.setAttribute(ERROR, "Product saved failed");
            return REDIRECT_SAVE_PRODUCT;
        }
        File saveFile = new ClassPathResource(IMG_PATH).getFile();
        Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + PRODUCT_IMG + File.separator + imageName);
        log.info("saveProduct path: {}", path);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
        session.setAttribute(SUCCESS, "Product saved success");
        return REDIRECT_SAVE_PRODUCT;
    }

    @GetMapping("/products")
    public String viewProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id, HttpSession session) {
        boolean result = productService.delete(id);
        if (result) {
            session.setAttribute(SUCCESS, "Product deleted successfully");
        } else {
            session.setAttribute(ERROR, "Product deleted failed");
        }
        return "redirect:/shopping-cart/admin/products";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute(CATEGORIES, categoryService.findAll());
        return "admin/edit_product";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, @RequestParam(value = "file", required = false) MultipartFile file,
                                HttpSession session) throws IOException {
        if (product.getDiscount() < 0 || product.getDiscount() > 100) {
            session.setAttribute(ERROR, "Invalid Discount");
            return REDIRECT_EDIT_PRODUCT + product.getId();
        }
        Product productUpdate = productService.update(product, file);
        if (productUpdate == null) {
            session.setAttribute(ERROR, "Product updated failed");
            return REDIRECT_EDIT_PRODUCT + product.getId();
        }
        session.setAttribute(SUCCESS, "Product updated successfully");
        return REDIRECT_EDIT_PRODUCT + product.getId();
    }
}

package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.model.Product;
import com.lysenko.shoppingcart.service.CategoryService;
import com.lysenko.shoppingcart.service.ProductRepository;
import com.lysenko.shoppingcart.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Controller
@RequestMapping("/shopping-cart/admin")
@RequiredArgsConstructor
//@MultipartConfig
public class AdminController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/add-product")
    public String adminAddProduct(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/add_product";
    }

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, @RequestParam(value = "isActive", required = false) Boolean isActive,
                               @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {

        String fileName = file != null ? file.getOriginalFilename() : "unknown.jpg";
        category.setImageName(fileName);
        if (!ObjectUtils.isEmpty(isActive)) {
            category.setIsActive(isActive);
        } else {
            category.setIsActive(false);
        }
        System.out.println(file);
        if (Boolean.TRUE.equals(categoryService.existCategory(category.getName()))) {
            session.setAttribute("error", "Category name already exist");
        } else {
            Category categorySave = categoryService.save(category);
            if (ObjectUtils.isEmpty(categorySave)) {
                session.setAttribute("error", "Category save failed");
            } else {
                File saveFile = new ClassPathResource("static/img").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "category_img" +
                        File.separator + (file != null ? file.getOriginalFilename() : "unknown.jpg"));
                System.out.println(path);
                if (file != null && !ObjectUtils.isEmpty(file.getOriginalFilename()) &&
                        !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }
                session.setAttribute("success", "Category save success");
            }
        }
        return "redirect:/shopping-cart/admin/category";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id, HttpSession session) {
        boolean isDeleted = categoryService.deleteById(id);
        if (isDeleted) {
            session.setAttribute("success", "Category deleted successfully");
        } else {
            session.setAttribute("error", "Category deletion failed");
        }
        return "redirect:/shopping-cart/admin/category";
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
        String imageName = file != null ? file.getOriginalFilename() : "unknown.jpg";
        if (!ObjectUtils.isEmpty(category)) {
            categoryById.setName(category.getName());
            categoryById.setImageName(imageName);
            categoryById.setIsActive(isActive);
        }

        Category updateCategory = categoryService.save(categoryById);

        if (ObjectUtils.isEmpty(updateCategory)) {
            session.setAttribute("error", "Category update failed");
        } else {
            File saveFile = new ClassPathResource("static/img").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "category_img" + File.separator + imageName);
            System.out.println(path);
            Files.copy(Objects.requireNonNull(file).getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("success", "Category updated successfully");
        }
        return "redirect:/shopping-cart/admin/editCategory/" + category.getId();
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product, @RequestParam(value = "file", required = false) MultipartFile image,
                              HttpSession session) throws IOException {

        String imageName = image.isEmpty() ? "unknown.jpg" : image.getOriginalFilename();
        product.setImage(imageName);
        Product saveProduct = productService.save(product);

        if (ObjectUtils.isEmpty(saveProduct)) {
            session.setAttribute("error", "Product save failed");
        } else {
            File saveFile = new ClassPathResource("static/img").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img" + File.separator + imageName);
            System.out.println(path);
            Files.copy(Objects.requireNonNull(image.getInputStream()), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("success", "Product save success");
        }

        return "redirect:/shopping-cart/admin/add-product";
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
            session.setAttribute("success", "Product deleted successfully");
        } else {
            session.setAttribute("error", "Product deletion failed");
        }
        return "redirect:/shopping-cart/admin/products";
    }

}

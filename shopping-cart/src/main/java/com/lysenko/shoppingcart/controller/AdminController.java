package com.lysenko.shoppingcart.controller;

import com.lysenko.shoppingcart.model.Category;
import com.lysenko.shoppingcart.service.CategoryService;
import jakarta.servlet.http.HttpSession;
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

@Controller
@RequestMapping("/shopping-cart/admin")
//@MultipartConfig
public class AdminController {

    private final CategoryService categoryService;

    public AdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String index() {
        return "admin/index";
    }

    @GetMapping("/add-product")
    public String adminAddProduct() {
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
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "category_img" + File.separator + (file != null ? file.getOriginalFilename() : "unknown.jpg"));
                System.out.println(path);
                if (!file.getOriginalFilename().isEmpty()) {
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
                                 @RequestParam("file") MultipartFile file, HttpSession session) throws IOException {

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
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "category_img" + File.separator + file.getOriginalFilename());
            System.out.println(path);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            session.setAttribute("success", "Category updated successfully");
        }
        return "redirect:/shopping-cart/admin/editCategory/" + category.getId();
    }

}

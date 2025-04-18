package com.lysenko.shoppingcart.service.impl;

import com.lysenko.shoppingcart.model.Product;
import com.lysenko.shoppingcart.repository.ProductRepository;
import com.lysenko.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.deleteById((long) product.getId());
            return true;
        }
        return false;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product, MultipartFile file) throws IOException {
        Product productById = findById((long) product.getId());
        String imageName = file.isEmpty() ? product.getImage() : file.getOriginalFilename();
        if (imageName != null) {
            productById.setImage(imageName);
            File saveFile = new ClassPathResource("static/img").getFile();
            Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img" + File.separator + imageName);
            System.out.println(path);
            Files.copy(Objects.requireNonNull(file).getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
        if (!ObjectUtils.isEmpty(product)) {
            productById.setCategory(product.getCategory());
            productById.setStock(product.getStock());
            productById.setPrice(product.getPrice());
            productById.setTitle(product.getTitle());
            productById.setDescription(product.getDescription());
            productById.setDiscount(product.getDiscount());
            productById.setIsActive(product.getIsActive());
            // 5=100*(5/100); 100-5=95
            BigDecimal discount = product.getPrice().multiply(BigDecimal.valueOf(product.getDiscount() / 100.0));
            BigDecimal discountedPrice = product.getPrice().subtract(discount);
            productById.setDiscountPrice(discountedPrice);
        }
        save(productById);
        return productById;
    }

    @Override
    public List<Product> findAllActiveByCategory(String category) {
        if (category != null) {
            return productRepository.findAllByIsActiveTrueAndCategoryIgnoreCase(category);
        } else {
            return findAllActive();
        }
    }

    @Override
    public List<Product> findAllActive() {
        return productRepository.findAllByIsActiveTrue();
    }
}

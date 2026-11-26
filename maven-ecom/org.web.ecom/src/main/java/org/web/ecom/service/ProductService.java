package org.web.ecom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web.ecom.dto.ProductRequest;
import org.web.ecom.dto.ProductResponse;
import org.web.ecom.model.Product;
import org.web.ecom.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = updateProductFromRequest(Product.builder().build(), productRequest);
        Product saveProduct = productRepository.save(product);
        return mapToProductResponse(saveProduct);
    }

    public Optional<ProductResponse> updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct = updateProductFromRequest(existingProduct, productRequest);
                    Product saveProduct = productRepository.save(existingProduct);
                    return mapToProductResponse(saveProduct);
                });
    }

    public List<ProductResponse> fetchAllProducts() {
        List<Product> products = productRepository.findByActiveTrue();
        return products.stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse fetchProductById(Long id) {
        return productRepository.findByIdAndActiveTrue(id)
                .map(this::mapToProductResponse)
                .orElse(null);
    }

    public boolean deleteProductById(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setActive(false);
                    productRepository.save(product);
                    return true;
                }).orElse(false);

    }


    private ProductResponse mapToProductResponse(Product saveProduct) {
        return ProductResponse.builder()
                .id(saveProduct.getId())
                .name(saveProduct.getName())
                .price(saveProduct.getPrice())
                .category(saveProduct.getCategory())
                .description(saveProduct.getDescription())
                .active(saveProduct.getActive())
                .imageUrl(saveProduct.getImageUrl())
                .stockQuantity(saveProduct.getStockQuantity())
                .build();
    }

    // IF USE SETTER NOT NEED RETURN PRODUCT
    // IF USE BUILDER NEED RETURN PRODUCT
    private Product updateProductFromRequest(Product product, ProductRequest productRequest) {
        return product.toBuilder()
                .name(productRequest.getName() != null ? productRequest.getName() : product.getName())
                .price(productRequest.getPrice() != null ? productRequest.getPrice() : product.getPrice())
                .category(productRequest.getCategory() != null ? productRequest.getCategory() : product.getCategory())
                .description(productRequest.getDescription() != null ? productRequest.getDescription() : product.getDescription())
                .imageUrl(productRequest.getImageUrl() != null ? productRequest.getImageUrl() : product.getImageUrl())
                .stockQuantity(productRequest.getStockQuantity() != null ? productRequest.getStockQuantity() : product.getStockQuantity())
                .build();
    }
}

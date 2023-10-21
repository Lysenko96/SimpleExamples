package org.gweep.productservice.service;

import lombok.extern.slf4j.Slf4j;
import org.gweep.productservice.dto.ProductRequest;
import org.gweep.productservice.dto.ProductResponse;
import org.gweep.productservice.model.Product;
import org.gweep.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product);
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll().stream().map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getPrice())).collect(Collectors.toList());
    }

}

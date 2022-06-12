package com.developeerscafe.productservice.service;

import com.developeerscafe.productservice.dto.ProductRequest;
import com.developeerscafe.productservice.dto.ProductResponse;
import com.developeerscafe.productservice.model.Product;
import com.developeerscafe.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
                .fullName(productRequest.getFullName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product)
    {
        return ProductResponse.builder()
                .id(product.getId())
                .fullName(product.getFullName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

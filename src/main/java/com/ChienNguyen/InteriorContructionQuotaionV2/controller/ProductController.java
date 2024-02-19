package com.ChienNguyen.InteriorContructionQuotaionV2.controller;

import com.ChienNguyen.InteriorContructionQuotaionV2.entity.Product;
import com.ChienNguyen.InteriorContructionQuotaionV2.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product updatedProduct) {
        Product product = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/related/{categoryId}")
    public List<Product> getRelatedProducts(@PathVariable Integer categoryId) {
        return productService.getRelatedProducts(categoryId);
    }

    @GetMapping("/{productId}/firstImage")
    public ResponseEntity<String> getFirstProductImage(@PathVariable Integer productId) {
        String imageUrl = productService.getFirstProductImage(productId);
        if (imageUrl != null) {
            return ResponseEntity.ok(imageUrl);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

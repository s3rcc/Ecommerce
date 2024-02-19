package com.ChienNguyen.InteriorContructionQuotaionV2.service;

import com.ChienNguyen.InteriorContructionQuotaionV2.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id);
    Product createProduct(Product product);
    Product updateProduct(Integer id, Product updatedProduct);
    void deleteProduct(Integer id);
    List<Product> getRelatedProducts(Integer categoryId);
    String getFirstProductImage(Integer productId);
}

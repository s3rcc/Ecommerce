package com.ChienNguyen.InteriorContructionQuotaionV2.service;

import com.ChienNguyen.InteriorContructionQuotaionV2.dao.ProductRepository;
import com.ChienNguyen.InteriorContructionQuotaionV2.entity.Product;
import com.ChienNguyen.InteriorContructionQuotaionV2.entity.ProductImage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to retrieve products", e);
        }
    }

    @Override
    public Product getProductById(Integer id) {
        try {
            return productRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        } catch (EntityNotFoundException e) {
            throw e; // Re-throw EntityNotFoundException
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to retrieve product with id: " + id, e);
        }
    }

    @Override
    public Product createProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to create product", e);
        }
    }


    @Override
    public Product updateProduct(Integer id, Product updatedProduct) {
        try {
            Product product = getProductById(id);
            // Update product properties
            product.setName(updatedProduct.getName());
            product.setWidth(updatedProduct.getWidth());
            product.setLength(updatedProduct.getLength());
            product.setHeight(updatedProduct.getHeight());
            product.setUnitPrice(updatedProduct.getUnitPrice());
            product.setUnit(updatedProduct.getUnit());
            product.setDescription(updatedProduct.getDescription());
            return productRepository.save(product);
        } catch (EntityNotFoundException e) {
            throw e; // Re-throw EntityNotFoundException
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to update product with id: " + id, e);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to delete product with id: " + id, e);
        }
    }

    @Override
    public List<Product> getRelatedProducts(Integer categoryId) {
        try {
            // Implement logic to fetch related products based on category or any other criteria
            return productRepository.findByCategoryId(categoryId);
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to retrieve related products for category id: " + categoryId, e);
        }
    }

    @Override
    public String getFirstProductImage(Integer productId) {
        try {
            Product product = getProductById(productId);
            List<ProductImage> images = product.getImages();
            if (images != null && !images.isEmpty()) {
                ProductImage firstImage = images.get(0);
                String imageUrl = firstImage.getImageUrl();
                if (imageUrl != null) {
                    return imageUrl;
                }
            }
            return null;
        } catch (EntityNotFoundException e) {
            throw e; // Re-throw EntityNotFoundException
        } catch (Exception e) {
            // Log or handle unexpected exceptions
            throw new RuntimeException("Failed to retrieve first image for product with id: " + productId, e);
        }
    }
}

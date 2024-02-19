package com.ChienNguyen.InteriorContructionQuotaionV2.dao;

import com.ChienNguyen.InteriorContructionQuotaionV2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Integer categoryId);
}

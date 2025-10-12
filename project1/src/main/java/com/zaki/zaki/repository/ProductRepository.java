package com.zaki.zaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaki.zaki.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}

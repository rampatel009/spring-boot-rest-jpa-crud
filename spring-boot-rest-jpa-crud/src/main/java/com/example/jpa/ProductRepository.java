package com.example.jpa;

import javax.transaction.Transactional;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


@Transactional
public interface ProductRepository extends JpaRepository<Product, String> {

}

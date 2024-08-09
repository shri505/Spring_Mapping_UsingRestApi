package com.example.Spring_Mapping_Eg2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Mapping_Eg2.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
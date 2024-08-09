package com.example.Spring_Mapping_Eg2.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Mapping_Eg2.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
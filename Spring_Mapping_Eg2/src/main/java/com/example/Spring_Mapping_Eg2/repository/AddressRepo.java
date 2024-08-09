package com.example.Spring_Mapping_Eg2.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Mapping_Eg2.entity.Address;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
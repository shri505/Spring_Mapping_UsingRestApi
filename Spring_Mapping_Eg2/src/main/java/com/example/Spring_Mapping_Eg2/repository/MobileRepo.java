package com.example.Spring_Mapping_Eg2.repository;

import com.example.Spring_Mapping_Eg2.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepo extends JpaRepository<Mobile,Integer>
{

}

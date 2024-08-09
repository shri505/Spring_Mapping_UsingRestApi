package com.example.Spring_Mapping_Eg2.repository;

import com.example.Spring_Mapping_Eg2.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Emp, Integer>
{

}

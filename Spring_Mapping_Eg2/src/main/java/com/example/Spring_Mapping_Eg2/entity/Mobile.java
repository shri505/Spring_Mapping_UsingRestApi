package com.example.Spring_Mapping_Eg2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mobilename;

    @OneToOne(mappedBy = "mobile")
    private Emp emp;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getMobilename() {
        return mobilename;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }
    }


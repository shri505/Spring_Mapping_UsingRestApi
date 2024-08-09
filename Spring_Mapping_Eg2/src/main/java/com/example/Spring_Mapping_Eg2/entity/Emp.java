package com.example.Spring_Mapping_Eg2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String empname;

    @OneToMany(mappedBy = "emp",cascade =CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mobile_id")
//    @OneToOne(mappedBy = "emp")
    private Mobile mobile;

    public void setMobile(Mobile mobile) {
        if (mobile != null) {
            mobile.setEmp(this); // Ensure bidirectional relationship is maintained
        }
        this.mobile = mobile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpname() {
        return empname;
    }


    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

}



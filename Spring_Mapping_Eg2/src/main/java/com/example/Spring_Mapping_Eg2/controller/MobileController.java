package com.example.Spring_Mapping_Eg2.controller;

import com.example.Spring_Mapping_Eg2.entity.Mobile;
import com.example.Spring_Mapping_Eg2.repository.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mobiles")
public class MobileController {

    @Autowired
    private MobileRepo mobileRepo;

    @GetMapping
    public List<Mobile> getAllMobiles() {
        return mobileRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mobile> getMobileById(@PathVariable int id) {
        Optional<Mobile> mobile = mobileRepo.findById(id);
        return mobile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mobile createMobile(@RequestBody Mobile mobile) {
        return mobileRepo.save(mobile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mobile> updateMobile(@PathVariable int id, @RequestBody Mobile mobile) {
        if (mobileRepo.existsById(id)) {
            mobile.setId(id);
            return ResponseEntity.ok(mobileRepo.save(mobile));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMobile(@PathVariable int id) {
        if (mobileRepo.existsById(id)) {
            mobileRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

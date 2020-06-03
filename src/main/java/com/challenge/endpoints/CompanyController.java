package com.challenge.endpoints;


import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id){
        return ResponseEntity.ok(companyService.findById(id).get());
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<Company>>  findByAccelerationId
            (@RequestParam(required = false) Long accelerationId){
        if (accelerationId != null){
            return ResponseEntity.ok(companyService.findByAccelerationId(accelerationId));
        }
        return null;
    }

    @GetMapping(params = "userId")
    public ResponseEntity<List<Company>>findByUserId(@RequestParam(required = false) Long userId){
        if(userId != null){
            return ResponseEntity.ok(companyService.findByUserId(userId));
        }
        return null;
    }


}

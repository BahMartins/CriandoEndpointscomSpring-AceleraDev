package com.challenge.endpoints;


import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userService.findById(userId).get());
    }

    @GetMapping(params = "accelerationName")
    public ResponseEntity<List<User>> findByAccelerationName
            (@RequestParam(required = false) String accelerationName){

            return ResponseEntity.ok(userService.findByAccelerationName(accelerationName));

    }

    @GetMapping(params = "companyId")
    public ResponseEntity<List<User>> findByCompanyId
            (@RequestParam(required = false) Long companyId){

            return ResponseEntity.ok(userService.findByCompanyId(companyId));

    }

}

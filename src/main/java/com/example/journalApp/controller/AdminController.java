package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserEntryService userEntryService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        List<User> all = userEntryService.getAllUser();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/create-admin-user")
    public ResponseEntity<?> createAdminUser(@RequestBody User user){
        userEntryService.saveAdmin(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.journalApp.controller;



import com.example.journalApp.entity.User;
import com.example.journalApp.service.UserEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    private UserEntryService userEntryService;


    @GetMapping("userName/{userName}")
    public ResponseEntity<User> findUserEntryById(@PathVariable String userName){
        User user = userEntryService.findByUserName(userName);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserEntryById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        userEntryService.deleteUserById(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> updateUserByID(@RequestBody User newEntry){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userEntryService.findByUserName(userName);
        user.setUserName(!newEntry.getUserName().equals("") ? newEntry.getUserName() : user.getUserName());
        user.setPassword(newEntry.getPassword() != null && !newEntry.getPassword().equals("") ? newEntry.getPassword() : user.getPassword());
        userEntryService.saveNewUser(user);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
}

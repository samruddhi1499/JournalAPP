

package com.example.journalApp.service;

import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserEntryRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserEntryService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private UserEntryRepo userEntryRepo;

    //private static final Logger LOGGER = LoggerFactory.getLogger(UserEntryService.class);

    public void saveUser(User user){

        userEntryRepo.save(user);
    }

    public void saveNewUser(User user){

       try{
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user.setRoles(Arrays.asList("USER"));
           userEntryRepo.save(user);
       }
       catch (Exception e){
            log.info("sdvhsdbjkcx");
            throw new RuntimeException(e);
       }
    }

    public List<User> getAllUser(){
        return userEntryRepo.findAll();
    }

    public Optional<User> findUserById(ObjectId id){
        return userEntryRepo.findById(id);
    }

    public void deleteUserById(String userName){
        User user = userEntryRepo.findByUserName(userName);
        userEntryRepo.deleteById(user.getId());
    }
    public User findByUserName(String userName){
        return userEntryRepo.findByUserName(userName);
    }

    public void saveAdmin(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userEntryRepo.save(user);
    }
}

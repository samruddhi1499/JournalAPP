package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {


    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    UserEntryService userEntryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(JournalEntryService.class);

    @Transactional
    public void saveJournalEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userEntryService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry save = journalEntryRepo.save(journalEntry);
            user.getJournalEntries().add(save);
            userEntryService.saveUser(user);
        }catch (Exception e){
            LOGGER.info("Entry not saved");
            throw new RuntimeException("An Error Occurred",e);
        }

    }
    public void saveJournalEntry(JournalEntry journalEntry){

        journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        try {
            boolean removed = false;
            User user = userEntryService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if(removed){
                userEntryService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
            return removed;

        }
        catch (Exception e){
            LOGGER.error("Entry not deleted");
            throw new RuntimeException("An Error Occured",e);
        }
    }



}

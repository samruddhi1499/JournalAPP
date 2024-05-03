package com.example.journalApp.cache;

import com.example.journalApp.entity.ConfigJournalAppEntity;
import com.example.journalApp.repository.ConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigRepo configRepo;

    public Map<String, String> applicationCache;

    @PostConstruct
    public void init(){
        applicationCache = new HashMap<>();
        List<ConfigJournalAppEntity> all = configRepo.findAll();
        for (ConfigJournalAppEntity configJournalAppEntity : all){
            applicationCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }

    }
}

package com.example.journalApp.service;

import com.example.journalApp.apiResponse.WeatherResponse;
import com.example.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    AppCache appCache;
    @Value("${weather.api.key}")
    private String apikey;

    public WeatherResponse getWheather(String city){

        String finalAPI = appCache.applicationCache.get("weather API").replace("<CITY>", city).replace("<APIKEY>", apikey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
}

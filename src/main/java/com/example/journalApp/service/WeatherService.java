package com.example.journalApp.service;

import com.example.journalApp.apiResponse.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String APIKEY = "17c144ea0f30a0a42cc07fb01d15e7f6";
    private static final String API = "https://api.openweathermap.org/data/2.5/find?q=CITY&lang=fr&appid=APIKEY&units=metric";

    public WeatherResponse getWheather(String city){

        String finalAPI = API.replace("CITY", city).replace("APIKEY", APIKEY);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
}

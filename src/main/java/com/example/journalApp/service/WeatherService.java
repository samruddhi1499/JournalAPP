package com.example.journalApp.service;

import com.example.journalApp.apiResponse.WeatherResponse;
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
    @Value("${weather.api.key}")
    private String apikey;
    private static final String API = "https://api.openweathermap.org/data/2.5/find?q=CITY&lang=fr&appid=APIKEY&units=metric";

    public WeatherResponse getWheather(String city){

        String finalAPI = API.replace("CITY", city).replace("APIKEY", apikey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;

    }
}

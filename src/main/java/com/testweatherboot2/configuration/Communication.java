package com.testweatherboot2.configuration;

import com.testweatherboot2.entity.ResultWeather;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class Communication {

    private final String URL4 = "https://api.openweathermap.org/data/2.5/onecall?";
    private final String URL5 = "&units=";
    private final String URL6 = "&exclude=daily,minutely&appid=886705b4c1182eb1c69f28eb8c520e20";

    private RestTemplate restTemplate;

    public Communication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResultWeather getResultWeather(String latAndLon, String measurement) {
        String resultURL = URL4 + latAndLon + URL5 + measurement + URL6;
        System.out.println(resultURL);
        ResultWeather resultWeather = restTemplate.getForObject(resultURL, ResultWeather.class);
        assert resultWeather != null;
        resultWeather.setLatAndLon(latAndLon);
        return resultWeather;
    }

}

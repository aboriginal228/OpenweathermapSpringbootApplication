package com.testweatherboot2.controllers;

import com.testweatherboot2.configuration.Communication;
import com.testweatherboot2.entity.ResultWeather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {

    private Communication communication;

    public MyController(Communication communication) {
        this.communication = communication;
    }


    @RequestMapping("/")
    public String mainView(Model model) {

        ResultWeather resultWeather = communication.getResultWeather("lat=55.75&lon=37.61", "metric");
        resultWeather.setName("Moscow");
        resultWeather.setMeasurement("metric");
        resultWeather.setWindDirection();
        model.addAttribute("city", resultWeather);
        return "main-view-result";
    }

    @RequestMapping("selectCity")
    public String mainView(Model model, ResultWeather resultWeather) {
        String measurement = resultWeather.getMeasurement();
        double windSpeed = communication.getResultWeather(resultWeather.getLatAndLon(), "metric").getCurrent().getWind_speed();
        resultWeather = communication.getResultWeather(resultWeather.getLatAndLon(), measurement);
        resultWeather.setMeasurement(measurement);
        resultWeather.setNameFromLatAndLon();
        resultWeather.setWindDirection();
        resultWeather.getHourly().get(0).setIntPop();
        resultWeather.getCurrent().setWind_speed(windSpeed);
        model.addAttribute("city", resultWeather);
        return "main-view-result";
    }
}

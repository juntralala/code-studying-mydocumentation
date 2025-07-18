package com.juntralala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TemperatureConversionController {

    @GetMapping(path = "/temperature/conversion")
    public ModelAndView showTemperaturePage(@RequestHeader(value = "Accept-Language") List<String> locale) {
        return new ModelAndView("temperature-conversion", Map.of(
                "title", "Aplikasi Konversi Suhu",
                "acceptLanguage", locale.get(0),
                "isCelsius", "true"
        ));
    }

    @PostMapping(path = "/temperature/conversion")
    public ModelAndView showResultTemperaturePage(@RequestHeader("Accept-Language") List<String> locale,
                                                  @RequestParam("temperature") int temperature,
                                                  @RequestParam("type") String type,
                                                  @RequestParam("conversionType") String conversionType) {
        int temperatureResult = 0;
        if (type.equals("celsius") && conversionType.equals("kelvin")) {
            temperatureResult = (int) Math.floor(temperature + 273.15);
        } else if (type.equals("kelvin") && conversionType.equals("celsius")) {
            temperatureResult = (int) Math.floor(temperature - 273.15);
        } else {
            temperatureResult = temperature;
        }
        return new ModelAndView("temperature-conversion", Map.of(
                "title", "Aplikasi Konversi Suhu",
                "acceptLanguage", locale.get(0),
                "result", String.valueOf(temperatureResult),
                "conversionType", conversionType,
                "isCelsius", type,
                "isCelcius", conversionType
        ));
    }

}

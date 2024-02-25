package com.quipux.prueba.controllers.hours;

import com.quipux.prueba.models.hours.HourModel;
import com.quipux.prueba.services.hours.HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hourController {
    private final HourService timeService;

    @Autowired
    public hourController(HourService timeService) {
        this.timeService = timeService;
    }

    @PostMapping("/convertTimeWords")
    public String convertHourWords(@RequestBody HourModel request) {
        int hour = request.getHour();
        int minutes = request.getMinutes();
        return timeService.convertHoursIntoWords(hour, minutes);
    }
}

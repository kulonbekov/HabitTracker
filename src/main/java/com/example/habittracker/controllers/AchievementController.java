package com.example.habittracker.controllers;

import com.example.habittracker.models.dtos.HabitDto;
import com.example.habittracker.services.AchievementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "5. Достижения")
@RestController
@RequestMapping(value = "/api/v1/achievement")
@RequiredArgsConstructor
public class AchievementController {

    private final AchievementService achService;

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ResponseEntity<?> save(@RequestParam Long profileId, @RequestParam Long habitId) {
        try {
            return new ResponseEntity<>(achService.save(profileId, habitId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}

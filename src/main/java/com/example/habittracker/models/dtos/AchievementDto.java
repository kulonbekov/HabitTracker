package com.example.habittracker.models.dtos;

import com.example.habittracker.models.entities.Profile;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AchievementDto extends BaseDto{
    String name;
    String description;
    Date date;
    int points;
    boolean isAchievement;
    String result;
    Profile profile;
}

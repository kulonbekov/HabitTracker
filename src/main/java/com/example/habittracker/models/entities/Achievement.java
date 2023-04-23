package com.example.habittracker.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_achievement")
public class Achievement extends BaseEntity{

    String name;
    String description;
    Date date;
    int points;
    boolean isAchievement;
    String result;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    Profile profile;

    protected void onCreate() {
        isAchievement = false;
    }

}


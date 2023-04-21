package com.example.habittracker.models.entities;

import com.example.habittracker.models.enums.Frequency;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_habit")
public class Habit extends BaseEntity{

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "target")
    int target;

    @Column(name = "frequency")
    @Enumerated(EnumType.STRING)
    Frequency frequency;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}

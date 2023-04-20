package com.example.habittracker.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Habit.TABLE_NAME)
public class Habit {

    public static final String TABLE_NAME = "HABITS";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "name_habit")
    private String nameHabit;

    @Column(name = "description")
    private String description;

    @Column(name = "count_in_day")
    private Integer countInDay;
}

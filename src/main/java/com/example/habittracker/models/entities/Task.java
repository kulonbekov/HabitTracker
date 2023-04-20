package com.example.habittracker.models.entities;

import com.example.habittracker.models.enums.DayWeekMonth;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Task.TABLE_NAME)
public class Task {

    public static final String TABLE_NAME = "TASK";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "execution_frequency")
    private Integer executionFrequency;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_week_month")
    private DayWeekMonth dayWeekMonth;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Habit habit;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
}

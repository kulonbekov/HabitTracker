package com.example.habittracker.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "tb_progress")
public class Progress extends BaseEntity{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Profile profile;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Habit habit;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name = "progress_date")
    private Date progressDate;

    @Column(name = "target")
    int target;
}

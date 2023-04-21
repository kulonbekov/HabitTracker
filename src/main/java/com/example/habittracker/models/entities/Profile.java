package com.example.habittracker.models.entities;

import com.example.habittracker.models.enums.ColorTheme;
import com.example.habittracker.models.enums.Language;
import com.example.habittracker.models.enums.Status;
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
@Table(name = "tb_profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "created")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date created;

    @Column(name = "updated")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;
    @Column(name = "name")
    String name;
    @Column(name = "icon")
    String icon;
    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    Language language;
    @Enumerated(EnumType.STRING)
    @Column(name = "color_theme")
    ColorTheme colorTheme;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @PrePersist
    protected void onCreate() {
        created = new Date();
        updated = new Date();
        status = Status.ACTIVE;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }
}

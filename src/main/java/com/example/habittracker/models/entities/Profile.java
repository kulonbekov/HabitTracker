package com.example.habittracker.models.entities;

import com.example.habittracker.models.enums.ColorTheme;
import com.example.habittracker.models.enums.Language;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
}

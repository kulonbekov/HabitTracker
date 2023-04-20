package com.example.habittracker.models.entities;

import com.example.habittracker.models.enums.Gender;
import com.example.habittracker.models.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_user")
public class User {

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

    @Column(name = "username", unique = true)
    @NotNull()
    String username;

    @Column(name = "email", unique = true)
    @NotNull()
    String email;

    @Column(name = "password")
    @NotNull()
    String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @NotNull()
    Gender gender;

    @Column(name = "age")
    @NotNull()
    int age;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    List<Role> roles;


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

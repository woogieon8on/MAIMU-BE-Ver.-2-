package com.example.chosim.chosim.domain.entity;


import com.example.chosim.chosim.domain.Locker;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    //social login 식별자
    private String username;

    private String name;

    private String email;

    private String role;

    private int maimuProfile;

    private LocalDate birth;

    private String maimuName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private List<Locker> lockers = new ArrayList<>();

    public void authUser(String role){
        this.role = "ROLE_USER";
    }

    public void initMaimuInfo(int maimuProfile, LocalDate birth, String maimuName){
        this.maimuProfile = maimuProfile;
        this.birth = birth;
        this.maimuName = maimuName;
    }
}

package com.copinstagram.instagram.member.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "roles")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Builder
    public Privilege(String name){
        this.name = name;
    }
    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles = new ArrayList<>();

}

package com.copinstagram.instagram.member.model.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"users", "privileges"})
@EqualsAndHashCode(exclude = "id")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Builder
    public Role(String name, List<Privilege> privileges){
        this.name = name;
        this.privileges = privileges;
    }

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges = new ArrayList<>();

    @Override
    public String getAuthority() {
        return this.name;
    }
}
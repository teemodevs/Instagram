package com.copinstagram.instagram.member.model.entity;

import com.copinstagram.instagram.board.model.dto.BoardUpdateRequestDto;
import com.copinstagram.instagram.board.model.entity.BaseTimeEntity;
import com.copinstagram.instagram.board.model.entity.Board;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = "authorities")
public class User extends BaseTimeEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(length = 40, nullable = false)
    private String username;
    @Column(length = 100, nullable = false)
    @Size(min = 4)
    private String password;

    /* UserDetails attribute */
    @Column
    private boolean accountNonExpired;
    @Column
    private boolean accountNonLocked;
    @Column
    private boolean credentialsNonExpired;
    @Column
    private boolean enabled;

    @Builder
    public User(String username, String password, Collection<Role> authorities) {
        this.username = username;
        this.password = password;
        if(null != authorities){
            this.authorities = new ArrayList<>(authorities);
        }
        this.enabled = true;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
    }

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> authorities = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * description : jpa 업데이트를 위한 메서드로 setter 대신 사용한다.
     * @param authorities
     * @return
     */
    public User addAuthorities(Collection<Role> authorities) {
        this.authorities = authorities;
        return this;
    }
}

package com.copinstagram.instagram.member.model.dto;

import com.copinstagram.instagram.member.model.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberSignUpRequestDto {
    private String username;
    private String password;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .authorities(null)
                .build();
    }

    @Builder
    public MemberSignUpRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
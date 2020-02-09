package com.copinstagram.instagram.member.model.dto;

import com.copinstagram.instagram.member.model.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private String email;
    private String password;

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
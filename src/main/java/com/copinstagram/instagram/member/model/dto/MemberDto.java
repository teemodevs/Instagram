package com.copinstagram.instagram.member.model.dto;

import com.copinstagram.instagram.board.model.entity.BaseTimeEntity;
import com.copinstagram.instagram.member.model.entity.Member;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private String email;
    private String password;


    public Member toEntity(){
        return Member.builder()
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
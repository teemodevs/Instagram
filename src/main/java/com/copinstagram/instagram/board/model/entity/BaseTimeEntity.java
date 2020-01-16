package com.copinstagram.instagram.board.model.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity가 이 클래스를 상속했을 때 이 클래스의 필드도 컬럼으로 만들어 주도록 설정
@EntityListeners(AuditingEntityListener.class)// auditing기능 추가
public abstract class BaseTimeEntity {

    @CreatedDate// 생성할 때 설정된다
    private LocalDateTime createdDate;

    @LastModifiedDate// Entity가 변경되면 설정된다
    private LocalDateTime modifiedDate;

}
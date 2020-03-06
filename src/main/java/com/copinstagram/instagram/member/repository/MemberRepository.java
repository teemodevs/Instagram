package com.copinstagram.instagram.member.repository;

import com.copinstagram.instagram.member.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
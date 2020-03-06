package com.copinstagram.instagram.member.service;

import com.copinstagram.instagram.member.model.dto.MemberSignUpRequestDto;
import com.copinstagram.instagram.member.model.entity.Role;
import com.copinstagram.instagram.member.model.entity.User;
import com.copinstagram.instagram.member.repository.MemberRepository;
import com.copinstagram.instagram.member.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Long joinUser(MemberSignUpRequestDto memberSignUpRequestDto) {
        // 비밀번호 암호화
        memberSignUpRequestDto.setPassword(passwordEncoder.encode(memberSignUpRequestDto.getPassword()));
        System.err.println(memberSignUpRequestDto);
        User newUser = memberSignUpRequestDto.toEntity();
        Role role = roleRepository.findByName("ROLE_MEMBER").orElseThrow(RuntimeException::new);
        newUser.addAuthorities(Arrays.asList(role));
        return memberRepository.save(memberSignUpRequestDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found '"+ username + "'"));
    }
}
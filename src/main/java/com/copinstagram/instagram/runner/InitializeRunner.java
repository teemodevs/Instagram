package com.copinstagram.instagram.runner;

import com.copinstagram.instagram.member.model.entity.Privilege;
import com.copinstagram.instagram.member.model.entity.Role;
import com.copinstagram.instagram.member.model.entity.User;
import com.copinstagram.instagram.member.repository.MemberRepository;
import com.copinstagram.instagram.member.repository.PrivilegeRepository;
import com.copinstagram.instagram.member.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Component
public class InitializeRunner implements ApplicationListener<ContextRefreshedEvent> {
    private MemberRepository memberRepository;
    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_RPIVILEGE");
        List<Privilege> adminPrivilege = Arrays.asList(readPrivilege, writePrivilege);
        Role memberRole = createRoleIfNotFound("ROLE_MEMBER", Arrays.asList(readPrivilege));
        Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivilege);
        adminRole = roleRepository.findByName("ROLE_ADMIN").orElseThrow(RuntimeException::new);
        System.err.println(adminRole);
        User user = User.builder()
                .username("admin@google.com")
                .password(passwordEncoder.encode("helloworld"))
                .authorities(Arrays.asList(adminRole))
                .build();
        memberRepository.save(user);
    }
    private Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepository.findByName(name).orElseGet(()->Privilege.builder().name(name).build());
        privilegeRepository.save(privilege);
        return privilege;
    }

    private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
        Role role = roleRepository.findByName(name).orElseGet(()->Role.builder().name(name).privileges(privileges).build());
        roleRepository.save(role);
        return role;
    }
}

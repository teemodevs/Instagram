package com.copinstagram.instagram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

@SpringBootApplication
@EnableJpaAuditing
public class InstagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstagramApplication.class, args);
		//DelegatingFilterProxy
		//SecurityFilterAutoConfiguration
		//WebAsyncManagerIntegrationFilter
		//SecurityContextPersistenceFilter
		//HttpSessionSecurityContextRepository
		//SecurityContextHolder
	}

}

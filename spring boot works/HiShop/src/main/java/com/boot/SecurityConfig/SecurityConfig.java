package com.boot.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.boot.config.CustomAuthenticaionEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
		http.authorizeRequests()
					.antMatchers("/", "/item/**").permitAll()
					.antMatchers("/s/**").anonymous()
					.antMatchers("/order/**","/member/**").hasAnyRole("USER", "ADMIN")
					.antMatchers("/admin/**").hasAnyRole("ADMIN");
		
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticaionEntryPoint());
		
		http.formLogin()
					.loginPage("/s/in")
					.usernameParameter("email")
					.successHandler(new SrcurityLoginSuccessHandler())
					.failureUrl("/s/signInFail");
		
		http.logout()
					.invalidateHttpSession(true)
					.logoutRequestMatcher(new AntPathRequestMatcher("/s/out"))
					.logoutSuccessUrl("/");
		
//		http.userDetailsService(securityUserDetailsService);
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
